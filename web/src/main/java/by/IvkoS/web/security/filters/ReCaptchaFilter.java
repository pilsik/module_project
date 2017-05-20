package by.IvkoS.web.security.filters;

import by.IvkoS.web.security.exceptions.RecaptchaAuthenticationException;
import by.IvkoS.web.security.exceptions.RecaptchaValidationException;
import by.IvkoS.web.security.validation.ValidationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@PropertySource("classpath:reCAPTCHA.properties")
public class ReCaptchaFilter extends UsernamePasswordAuthenticationFilter {

    public static final Logger logger = LoggerFactory.getLogger(ReCaptchaFilter.class);

    @Value("${google.recaptcha.key.secret}")
    private String secretKey ="6Ld2mhkUAAAAAHsmDbDHFuzjeGSBCgwWMg3vkgWf";

    @Value("${google.recaptcha.URL}")
    private String reCaptchaUrl="https://www.google.com/recaptcha/api/siteverify";

    @Autowired
    @Qualifier("rememberMeServices")
    @Override
    public void setRememberMeServices(RememberMeServices rememberMeServices) {
        super.setRememberMeServices(rememberMeServices);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        logger.info("ПРОВЕРКА RECAPTHCA");
        if (getUsernameParameter() == null) {
            throw new RecaptchaAuthenticationException("Username empty");
        }
        String recaptchaResponse = request.getParameter("g-recaptcha-response");
        logger.info(String.format("g-recaptcha-response : %s", recaptchaResponse));
        if (!validation(recaptchaResponse, request.getRemoteAddr())) {
            throw new RecaptchaAuthenticationException(
                    String.format("Error validating reCAPTCHA \nUser: %s\nPassword: %s",
                            getUsernameParameter(), getPasswordParameter()));
        }
        return super.attemptAuthentication(request, response);
    }

    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    @Autowired
    public void setAuthenticationSuccessHandler(AuthenticationSuccessHandler successHandler) {
        super.setAuthenticationSuccessHandler(successHandler);
    }

    @Override
    @Autowired
    public void setAuthenticationFailureHandler(AuthenticationFailureHandler failureHandler) {
        super.setAuthenticationFailureHandler(failureHandler);
    }

    private boolean validation(String userResponse, String ipAddress) {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<>();
        parameters.add("secret", this.secretKey);
        parameters.add("response", userResponse);
        parameters.add("remoteip", ipAddress);
        logger.info(String.format("ReCaptcha validation. response: %s\n remoteip %s", userResponse, ipAddress));
        try {
            ValidationResult result = restTemplate.postForEntity(reCaptchaUrl, parameters, ValidationResult.class).getBody();
            logger.info(String.format("Response from ReCaptcha\n%s", result.toString()));
            return result.isSuccess();
        } catch (RestClientException ex) {
            throw new RecaptchaValidationException(ex);
        }

    }
}
