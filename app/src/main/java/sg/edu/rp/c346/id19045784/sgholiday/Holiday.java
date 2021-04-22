package sg.edu.rp.c346.id19045784.sgholiday;

public class Holiday {
    private String name;
    private String image;
    private  String date;

    public Holiday(String name, String image, String date){
        this.name = name;
        this.image = image;
        this.date = date;
    }
    public String getName(){
        return name;
    }
    public String getImage(){
        return image;
    }
    public String getDate(){
        return date;
    }
}
