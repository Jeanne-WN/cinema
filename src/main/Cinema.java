import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class Cinema {

    public Double getBillFor(String json) throws IllegalInput {
        Map map = getMapFromInput(json);
        return getCount(map) * getPrice(map) * getDiscountRateByPayWay(map);
    }

    private Double getDiscountRateByPayWay(Map map) {
        Object wayToPay = map.get("pay_by");
        return "PFBCCard".equals(wayToPay) ? 0.7 : 1;
    }

    private double getPrice(Map map) throws IllegalInput {
        return getMovieType(map).equals("3D") ? 90D : 60D;
    }

    private String getMovieType(Map map) throws IllegalInput {
        Object type = map.get("movie_type");
        if (type == null || type.toString().equals("2D")) {
            return "2D";
        } else if (type.toString().equals("3D")) {
            return "3D";
        } else {
            throw new IllegalInput("Illegal movie type");
        }
    }

    private int getCount(Map map) {
        String count = map.get("count").toString();
        return new Double(count).intValue();
    }

    private Map getMapFromInput(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, HashMap.class);
    }
}
