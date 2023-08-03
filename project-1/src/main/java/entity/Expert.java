package entity;

import entity.enums.ExpertStatus;
import exceptions.ImageException;
import jakarta.persistence.*;
import lombok.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.Base64;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Expert extends Users{
    @Enumerated(EnumType.STRING)
    private ExpertStatus expertStatus;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "expert_subservice",
            joinColumns = {@JoinColumn(name = "expert_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "subservice_id",referencedColumnName = "id")}
    )
    private Set<SubService> subServices;
    @OneToOne
    private Wallet wallet;
    private int rate =0;
    private String image;

    public void setImage(String image)throws ImageException  {
        this.image = convertImageToBase64(image);
    }
    public String convertImageToBase64(String imagePath) throws ImageException {
        File file = new File(imagePath);
        try (FileInputStream imageInFile = new FileInputStream(file)) {

            byte[] imageData = new byte[(int) file.length()];
            if (imageData.length<300){
                imageInFile.read(imageData);
                return Base64.getEncoder().encodeToString(imageData);
            }else {
                throw new ImageException("Your photo must be less than 300 KB");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}

