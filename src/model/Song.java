package model;

import run.MusicManagement;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Song {
    private String songId;
    private String songName;
    private String descriptions ;
    private Singer singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;
    public Song() {

     }
    public Song(String songId, String songName, String descriptions, Singer singer, String songWriter, Date createdDate, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void inputSongData(Scanner scanner){
//      1.  Mã bài hát – String (Có 4 ký tự và bắt đầu bằng kí tự S, không trùng lặp)
        this.songId = inputSongId(scanner);
//      2.  Tên bài hát – String (Không được để trống)
        this.songName = inputSongName(scanner);
//      3.  Descriptions – mô tả bài hát – String
        this.descriptions = inputSongDescriptions(scanner);
//      4.  Singer - ca sĩ - Singer (không được null)
        this.singer = inputSinger(scanner);
//      5.  Người sáng tác- String (không được để trống)
        this.songWriter = inputSongWriter(scanner);
//      6.  Ngày tạo - Date (mặc định là thời gian hệ thống)
        this.createdDate = dispalySongDate();
//      7.  Trạng thái - boolean
        this.songStatus = inputSongStatus(scanner);
    }
    public void updateSong(Scanner scanner){
        //      2.  Tên bài hát – String (Không được để trống)
        this.songName = inputSongName(scanner);
//      3.  Descriptions – mô tả bài hát – String
        this.descriptions = inputSongDescriptions(scanner);
//      4.  Singer - ca sĩ - Singer (không được null)
        this.singer = inputSinger(scanner);
//      5.  Người sáng tác- String (không được để trống)
        this.songWriter = inputSongWriter(scanner);
//      6.  Ngày tạo - Date (mặc định là thời gian hệ thống)
        this.createdDate = dispalySongDate();
//      7.  Trạng thái - boolean
        this.songStatus = inputSongStatus(scanner);
    }

    public String inputSongId(Scanner scanner){
        System.out.println("Enter Song ID: ");
        do {
          String songId = scanner.nextLine();
          String SongIdRegex ="[S]\\w{3}";
          if (Pattern.matches(SongIdRegex,songId)) {
             boolean isExist = false;
             for (int i = 0; i< MusicManagement.indexSong;i++){
                 if (MusicManagement.arrSong[i].getSongId().equals(songId)){
                     isExist = true;
                     break;
                 }
             }
             if(isExist){
                 System.err.println("Song ID already exists, please try again");
             }else  {
                 return songId;
              }
          }else {
              System.err.println("Song ID have 4 characters and starts with the letter S, pleas try again.");
          }
        }while (true);
    }

    public String inputSongName(Scanner scanner){
        System.out.println("Enter song name");
        do {
            String songName = scanner.nextLine();
            if (songName.trim().length()>0){
                return songName;
            }else {
                System.err.println("Song name cannot be empty, please try again.");
            }
        }while (true);
    }

    public String inputSongDescriptions(Scanner scanner){
        System.out.println("Enter Descriptions of song");
        return scanner.nextLine();
    }
    public String inputSongWriter(Scanner scanner){
        System.out.println("Enter Song Writer");
        do {
          String writerSong = scanner.nextLine();
          if (writerSong.trim().length()>0){
              return writerSong;
          }else {
              System.err.println("Song Writer cannot be empty, please try again.");
          }
        }while (true);
    }
    public Singer inputSinger(Scanner scanner){
        System.out.println("Enter Song of Singer ");
        do {
            for (int i = 0; i< MusicManagement.indexSinger;i++){
                System.out.println((i+1)+": " + MusicManagement.arrSinger[i].getSingerName());
            }
            System.out.println("choice singer");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice >0 && choice <= MusicManagement.indexSinger ) {
                return MusicManagement.arrSinger[choice-1];
            }else {
                System.err.println("singer ban chon k hop le, vui long chon lai");
            }
        }while (true);
    }

    public boolean inputSongStatus(Scanner scanner){
        System.out.println("Enter Song Status");
        do {
           String songStatus = scanner.nextLine();
           if (songStatus.equals("true")||songStatus.equals("false")){
               return Boolean.parseBoolean(songStatus);
           }else {
               System.err.println("Singer gender only accepts 2 values, true or false, please try again.");
           }
        }while (true);
    }
   public Date dispalySongDate(){
      return this.createdDate = new Date();
   }
   public void displaySongData(){
       System.out.println("------------------------------------------------------------------------------------------------------------");
       System.out.println("Song Id\t\tSong Name \t\tDescription\t\t\tsinger\t\tSong Writer\t\tDate\t\tSong Status");
       System.out.printf("%-10s%-15s%-20s%-17s%-15s%-15s%-15s\n",
               this.songId, this.songName, this.descriptions, this.singer.getSingerName(), this.songWriter, this.createdDate,
               this.songStatus?"active":"not active");
   }
}
