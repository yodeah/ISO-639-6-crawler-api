import java.io.Serializable;

/**
 * Created by andras on 2015.04.21..
 */
public class AlphaObject implements Serializable {


    final private String alpha_4_id;
    final private String alpha_4_parent_id;
    final private String reference_name;

    public AlphaObject(String alpha_4_id, String alpha_4_parent_id, String reference_name) {
        this.alpha_4_id = alpha_4_id;
        this.alpha_4_parent_id = alpha_4_parent_id;
        this.reference_name = reference_name;
    }
}
