package data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.morphia.annotations.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id @JsonIgnore @javax.persistence.Id
    private ObjectId _id;

    private String username;

    public String getId(){
        return _id.toHexString();
    }
    public void setID(String id){
        _id = new ObjectId(id);
    }

}
