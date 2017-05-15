package by.IvkoS.domain.dto;

import by.IvkoS.database.models.employers.Employer;
import by.IvkoS.database.models.employers.Position;
import by.IvkoS.database.models.tree.TreeBranch;

import javax.xml.bind.annotation.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataForXML {

    @XmlElement(name = "employer")
    private List<Employer> employers;

    public List<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(List<Employer> employers) {
        this.employers = employers;
    }

    @XmlElement(name = "branch")
    private List<TreeBranch> branches;

    public List<TreeBranch> getBranches() {
        return branches;
    }

    public void setBranches(List<TreeBranch> branches) {
        this.branches = branches;
    }
}
