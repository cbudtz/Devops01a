package data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.morphia.annotations.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id @JsonIgnore
    private ObjectId _id;
    private String username;

    public String getId(){
        return _id.toHexString();
    }
    public void setID(String id){
        _id = new ObjectId(id);
    }

}
