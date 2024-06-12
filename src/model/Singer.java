package model;

import run.MusicManagement;

import java.util.Scanner;

public class Singer {
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public Singer() {

    }
    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void inputSingerData(Scanner scanner){
//        1.Mã ca sĩ – int (Tự động tăng)
        this.singerId = inputSingerId();
//        2.Tên ca sĩ – String (Không được để trống)
        this.singerName = inputSingerName(scanner);
//        3.Tuổi – int (Phải lớn hơn 0)
        this.age = inputSingerAge(scanner);
//        4.Quốc tịch – String (không được để trống)
        this.nationality = inputSingerNationality(scanner);
//        5.Giới tính - boolean
        this.gender = inputSingerGender(scanner);
//        6.Thể loại - String (Không được để trống)
        this.genre = inputSingerGenre(scanner);

    }

    public int inputSingerId(){
      if (MusicManagement.indexSinger==0){
          return 1;
      }else {
          int idMaxSinger = MusicManagement.arrSinger[0].getSingerId();
          for (int i=1;i<MusicManagement.indexSinger;i++){
              if (idMaxSinger < MusicManagement.arrSinger[i].getSingerId()){
                  idMaxSinger = MusicManagement.arrSinger[i].getSingerId();
              }
          }
          return idMaxSinger + 1;
      }
    }

    public String inputSingerName(Scanner scanner) {
        System.out.println("Enter Singer Name:");
        do {

            String singerName = scanner.nextLine();
            if (singerName.trim().length() > 0) {
                return singerName;
            } else{
                System.err.println("Singer Name cannot be empty, please try again.");;
            }
        }while (true);
    }

    public int inputSingerAge(Scanner scanner){
        System.out.println("Enter Singer Age:");
        do {
            int age = Integer.parseInt(scanner.nextLine());
            if (age > 0) {
                return age;
            }else {
                System.err.println("Singer Age must be > 0, please try again.");
            }
        }while (true);
    }
    public String inputSingerNationality(Scanner scanner){
        System.out.println("Enter Singer Nationality:");
        do {
            String nationality = scanner.nextLine();
            if (nationality.trim().length() > 0) {
                return nationality;
            }else {
                System.err.println("Singer Nationality cannot be empty, please try again.");
            }
        }while (true);
    }
    public boolean inputSingerGender(Scanner scanner){
        System.out.println("Enter Singer Gender:");
        do {
           String gender = scanner.nextLine();
           if (gender.equals("true")||gender.equals("false")){
               return Boolean.parseBoolean(gender);
           }else {
               System.err.println("Singer gender only accepts 2 values, true or false, please try again.");
           }
        }while (true);
    }
    public String inputSingerGenre(Scanner scanner){
        System.out.println("Enter Singer Genre:");
        do {
            String genre = scanner.nextLine();
            if(genre.trim().length()>0){
                return genre;
            }else {
                System.err.println("Singer Genre cannot be empty, please try again.");
            }
        }while (true);
    }

    public void displaySingerData(){
        System.out.println("------------------------------------------------------------------------------------------------------------");
        System.out.println("Singer ID\t\tSinger Name\t\tsinger age\t\tNationality\t\tGender\t\tGenre");
        System.out.printf("%-16d%-16s%-16d%-16s%-12s%-16s\n",
                this.singerId, this.singerName, this.age, this.nationality,
                this.gender?"Male": "Female", this.genre);
    }
}
