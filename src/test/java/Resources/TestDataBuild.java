package Resources;

import java.util.ArrayList;
import java.util.List;

import POJO.addPlace;
import POJO.addPlace_location;

public class TestDataBuild{

    public addPlace addPlacePayload(String name, String language, String address){

    addPlace p = new addPlace();

    p.setAccuracy(50);
    p.setAddress(address);
    p.setLanguage(language);
    p.setPhone_number("(+91) 9876546512");
    p.setName(name);
    p.setWebsite("29, side layout, cohen 09");
    List<String> myList = new ArrayList<String>();
    myList.add("shoe park");
    myList.add("shop");
    p.setTypes(myList);

    addPlace_location loc = new addPlace_location();
    loc.setLat(-38.383494);
    loc.setLng(33.427362);
    p.setLocation(loc);
    return p;
}

public String deletePlacePayload(String place_id){

    return "{\r\n    \"place_id\":\""+place_id+"\"\r\n}";
}

}
