package tn.esprit.dari.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("D")
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryMan extends Utilisateur implements Serializable {


 @JsonIgnore
@OneToMany(mappedBy = "deliveryMan")
 private List<Delivery> deliveryList;

 @JsonIgnore
 public List<Delivery> getDeliveryList() {
  return deliveryList;
 }

 public void setDeliveryList(List<Delivery> deliveryList) {
  this.deliveryList = deliveryList;
 }

}
