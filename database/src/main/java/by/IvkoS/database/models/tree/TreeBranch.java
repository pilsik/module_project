package by.IvkoS.database.models.tree;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Класс реализующий хранение данных для ветвей(csv файл)
 */
@Entity
@Table(name = "treetable")
public class TreeBranch  implements java.io.Serializable{

    @Id
    @Column(name = "branch_id")
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "parent_id")
    private int parentId;

    public TreeBranch() {
    }

    public TreeBranch(int id, String text, int parentId) {
        this.id = id;
        this.text = text;
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "TreeBranch{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
