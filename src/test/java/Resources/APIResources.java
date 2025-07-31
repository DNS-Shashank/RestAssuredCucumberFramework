package Resources;

// Enum is a special class that represents a group of constants (unchangeable variables)
// Each enum constant is public, static and final by default
// Enum can have attributes, constructors and methods
public enum APIResources {

    AddPlaceAPI("/maps/api/place/add/json"),
    GetPlaceAPI("/maps/api/place/get/json"),
    DeletePlaceAPI("/maps/api/place/delete/json");

    private String resource;
    APIResources(String resource){
        this.resource = resource;
    }
    public String getResource(){
        return resource;
    }

}
