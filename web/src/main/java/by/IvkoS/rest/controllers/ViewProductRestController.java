package by.IvkoS.rest.controllers;

import by.IvkoS.mongodb.models.Product;
import by.IvkoS.mongodb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/products")
public class ViewProductRestController {

    private static final String UPLOAD_DIRECTORY = "img";

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String addProduct(ModelMap modelMap) {
        Product product = new Product();
        modelMap.addAttribute("product", product);
        return "addProduct";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String createProduct(Product product, HttpServletRequest request, @RequestParam("files") MultipartFile[] files) {
        // constructs the directory path to store upload file
        String uploadPath = request.getSession().getServletContext().getRealPath("")
                + UPLOAD_DIRECTORY + File.separator + product.getName() + File.separator;
        // creates the directory if it does not exist
        createDir(uploadPath);
        product.setImgPath(saveImages(uploadPath,product.getName(),files));
        productService.add(product);
        return "redirect:/rest/products/id/" + product.getId();
    }

    private boolean createDir(String uploadPath) {
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        return true;
    }

    private String[] saveImages(String uploadPath,String productName,MultipartFile[] files) {
        List<String> imgPaths = new ArrayList<>();
        // parses the request's content to extract file data
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue; //next pls
            }
            Path filePath = Paths.get(uploadPath + File.separator + file.getOriginalFilename());
            try {
                byte[] bytes = file.getBytes();
                Files.write(filePath, bytes);
                imgPaths.add(productName + File.separator + file.getOriginalFilename());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        String[] stockArr = new String[imgPaths.size()];
        return imgPaths.toArray(stockArr);
    }

}
