package run;

import model.Singer;
import model.Song;

import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class MusicManagement {
    public static Singer[] arrSinger = new Singer[100];
    public static Song[] arrSong = new Song[100];
    public static int indexSinger = 0;
    public static int indexSong = 0;

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       do {
           System.out.println("*************MUSIC-MANAGEMENT***************");
           System.out.println("1. Quản lý ca sĩ ");
           System.out.println("2. Quản lý bài hát");
           System.out.println("3. Tìm kiếm bài hát");
           System.out.println("4. Thoát");
           System.out.println("Your choice");
           int choice = Integer.parseInt(scanner.nextLine());
           switch (choice) {
               case 1:
                   MusicManagement.displaySingerMenu(scanner);
                   break;
               case 2:
                   MusicManagement.displaySongMenu(scanner);
                   break;
               case 3:
                   MusicManagement.displaySearchMenu(scanner);
                   break;
               case 4:
                   System.exit(0);
                   break;
               default:
                   System.err.println("please enter choice 1-4");
           }
       }while (true);
    }

    public static void displaySingerMenu(Scanner scanner){
        boolean isExist = true;
        do {
            System.out.println("*************SINGER-MANAGEMENT**************");
            System.out.println("1. Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới");
            System.out.println("2. Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
            System.out.println("3. Thay đổi thông tin ca sĩ theo mã id");
            System.out.println("4. Xóa ca sĩ theo mã id ");
            System.out.println("5. Thoát");
            System.out.println("Your choice");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    MusicManagement.inputSinger(scanner);
                    break;
                case 2:
                    MusicManagement.displaySinger();
                    break;
                case 3:
                    MusicManagement.updateSinger(scanner);
                    break;
                case 4:
                    MusicManagement.deleteSinger(scanner);
                    break;
                case 5:
                    isExist = false;
                    break;
                default:
                    System.err.println("please enter choice 1-6");
            }
        }while (isExist);
    }

    public static void inputSinger(Scanner scanner){
        System.out.println("Enter the number of singer to enter information");
        int singerNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < singerNumber; i++) {
            arrSinger[i] = new Singer();
            arrSinger[i].inputSingerData(scanner);
            indexSinger++;
        }
    }

    public static void displaySinger(){
        for (int i = 0; i < indexSinger; i++) {
            arrSinger[i].displaySingerData();
        }
    }

    public static void updateSinger(Scanner scanner){
        System.out.println("Enter the Book Id to update");
        int singerId = Integer.parseInt(scanner.nextLine());
        int indexUpdate = getIndexById(singerId);
        if (indexUpdate >=0 ) {
            boolean isExist = true;
            do {
                System.out.println("1. Update of singer name");
                System.out.println("2. Update of singer age");
                System.out.println("3. Update of singer nationality");
                System.out.println("4. Update of singer gender");
                System.out.println("5. Update of singer genre");
                System.out.println("6. Exit");
                System.out.println("Your choice");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                      arrSinger[indexUpdate].setSingerName(scanner.nextLine());
                        break;
                    case 2:
                      arrSinger[indexUpdate].setAge(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 3:
                      arrSinger[indexUpdate].setNationality(scanner.nextLine());
                        break;
                    case 4:
                       arrSinger[indexUpdate].setGender(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 5:
                        arrSinger[indexUpdate].setGenre(scanner.nextLine());
                        break;
                    case 6:
                        isExist = false;
                        break;
                    default:
                        System.err.println("please enter choice 1-6");
                }

            }while (isExist);
        }else {
            System.err.println("The Book Id does not exist");
        }

    }

    public static int getIndexById(int singerId){
        for (int i = 0; i<indexSinger; i++){
            if (MusicManagement.arrSinger[i].getSingerId() == singerId){
                return i;
            }
        }return -1;
    }

    public static void deleteSinger(Scanner scanner){
        System.out.println("Enter the singer Id to delete");
        int singerId = Integer.parseInt(scanner.nextLine());
        int indexDelete = getIndexById(singerId);
        if (indexDelete >=0) {
            boolean check = false;
            for (int i = 0; i < indexSong; i++) {
                 if (MusicManagement.arrSinger[i].getSingerId() == singerId ){
                     check = true;
                     break;
                 }
            }
            if (check) {
                System.err.println("If a singer has a song, it cannot be deleted");
            }else {
                for (int i = indexDelete; i < indexSinger; i++) {
                    arrSinger[i] = arrSinger[i+1];
                }
                indexSinger--;
            }
        }else {
            System.err.println("The singer Id does not exist");
        }

    }

    public static void displaySongMenu(Scanner scanner){
        boolean isExist = true;
        do {
            System.out.println("*************SONG-MANAGEMENT**************");
            System.out.println("1. Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mới ");
            System.out.println("2. Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
            System.out.println("3. Thay đổi thông tin bài hát theo mã id");
            System.out.println("4. Xóa bài hát theo mã id ");
            System.out.println("5. Thoát");
            System.out.println("Your choice");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    MusicManagement.inputSong(scanner);
                    break;
                case 2:
                    MusicManagement.displaySong();
                    break;
                case 3:
                    MusicManagement.updateSong(scanner);
                    break;
                case 4:
                    MusicManagement.deleteSong(scanner);
                    break;
                case 5:
                    isExist = false;
                    break;
                default:
                    System.err.println("please enter choice 1-5");
            }
        }while (isExist);
    }
    public static void inputSong(Scanner scanner){
        System.out.println("Enter the number of singer to enter information");
        int songNumber = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < songNumber; i++) {
            arrSong[i] = new Song();
            arrSong[i].inputSongData(scanner);
            indexSong++;
        }

    }
    public static void displaySong(){
        System.out.println("hihi");
        for (int i = 0; i < indexSong; i++) {
            arrSong[i].displaySongData();
        }
    }

    public static int getIndexSongById(String songId){
        for (int i = 0; i < indexSong; i++) {
            if (MusicManagement.arrSong[i].getSongId().equals(songId)) {
                return i;
            }
        }
        return -1;
    }

    public static void updateSong(Scanner scanner){
        System.out.println("Enter the Song Id to update");
         String songId = scanner.nextLine();
         int indexUpdate = getIndexSongById(songId);
         if (indexUpdate >= 0) {
             arrSong[indexUpdate].updateSong(scanner);
         } else {
             System.err.println("The Song Id does not exist");
         }
    }
    public static void deleteSong(Scanner scanner){
        System.out.println("Enter the Song Id to delete");
        String songId = scanner.nextLine();
        int indexDelete = getIndexSongById(songId);
        if (indexDelete >=0) {
            for (int i = indexDelete; i < indexSong; i++) {
                arrSong[i] = arrSong[i+1];
            }
            indexSong--;
        }else {
            System.err.println("The Song Id does not exist");
        }
    }

    public static void displaySearchMenu(Scanner scanner){
        boolean isExist = true;
        do {
            System.out.println("*************SEARCH-MANAGEMENT***************");
            System.out.println("1. Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại  ");
            System.out.println("2. Tìm kiếm ca sĩ theo tên hoặc thể loại");
            System.out.println("3. Hiển thị danh sách bài hát theo thứ tự tên tăng dần");
            System.out.println("4. Hiển thị 10 bài hát được đăng mới nhất  ");
            System.out.println("5. Thoát");
            System.out.println("Your choice");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                   MusicManagement.searchSongByName(scanner);
                    break;
                case 2:
                    MusicManagement.searchSingerByNameOrGenre(scanner);
                    break;
                case 3:
                    MusicManagement.sortSingerByName();
                    break;
                case 4:
                    MusicManagement.displayNameSongsSoon();
                    break;
                case 5:
                    isExist = false;
                    break;
                default:
                    System.err.println("please enter choice 1-5");
            }
        }while (isExist);
    }

    public static void searchSongByName(Scanner scanner){
        System.out.println("Enter the Song Name to search");
        String songNameOrGenre = scanner.nextLine().toLowerCase();
        int cntSong = 0;
        System.out.println("Song you need to find : ");
        for (int i = 0; i < indexSong; i++) {
            if (MusicManagement.arrSong[i].getSinger().getSingerName().toLowerCase().contains(songNameOrGenre)
                    ||MusicManagement.arrSong[i].getSinger().getGenre().toLowerCase().contains(songNameOrGenre)) {
                arrSong[i].displaySongData();
            }
            cntSong++;
        }
        System.out.println("Song number to find: " + cntSong);
    }
public static void searchSingerByNameOrGenre(Scanner scanner){
        System.out.println("Enter the Singer Name or Genre or to search");
        String songNameOrGenre = scanner.nextLine().toLowerCase();
        int cntSinger = 0;
        System.out.println("Singer you need to find : ");
        for (int i = 0; i < indexSinger; i++) {
            if (MusicManagement.arrSinger[i].getSingerName().toLowerCase().contains(songNameOrGenre)||
            MusicManagement.arrSinger[i].getGenre().toLowerCase().contains(songNameOrGenre)) {
                arrSinger[i].displaySingerData();
            }
            cntSinger++;
        }
        System.out.println("Singer number to find: " + cntSinger);

}
  public static void sortSingerByName(){
        for (int i = 0; i < indexSinger -1; i++) {
            for (int j = i+1; j < indexSinger-i-1; j++) {
                if (arrSinger[j].getSingerName()!=null && arrSinger[j+1].getSingerName()!=null) {
                    if (arrSinger[j].getSingerName().compareTo(arrSinger[j+1].getSingerName())>0) {
                        Singer temp = arrSinger[j];
                        arrSinger[j] = arrSinger[j+1];
                        arrSinger[j+1] = temp;
                    }
                }

            }
        }

  }
  public static void displayNameSongsSoon(){
        if (indexSong<10){
            System.out.println("List song must greater than 10");
            return;
        }
        int cntSong = 0;
        for (int i = indexSong-1; cntSong<=10 ; i--) {
            System.out.println("Song :" + (cntSong+1));
            arrSong[i].displaySongData();
            cntSong++;
        }
  }
}
