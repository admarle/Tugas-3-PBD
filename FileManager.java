import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public static void simpanMenu(ArrayList<MenuItem> menu, String fileName) {

        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {

            for (MenuItem item : menu) {

                if (item instanceof Makanan) {

                    Makanan m = (Makanan) item;

                    pw.println("MAKANAN,"
                            + m.getNama() + ","
                            + m.getHarga() + ","
                            + m.getJenisMakanan());

                } else if (item instanceof Minuman) {

                    Minuman m = (Minuman) item;

                    pw.println("MINUMAN,"
                            + m.getNama() + ","
                            + m.getHarga() + ","
                            + m.getJenisMinuman());

                } else if (item instanceof Diskon) {

                    Diskon d = (Diskon) item;

                    pw.println("DISKON,"
                            + d.getNama() + ","
                            + d.getDiskon());
                }
            }

        } catch (IOException e) {
            System.out.println("Gagal menyimpan menu.");
        }
    }

    public static void simpanStruk(Pesanan pesanan,
                                   String fileName) {

        try (PrintWriter pw =
                     new PrintWriter(new FileWriter(fileName))) {

            for (MenuItem item :
                    pesanan.getDaftarPesanan()) {

                pw.println(item.getNama()
                        + " - Rp"
                        + item.getHarga());
            }

            pw.println("------------------");
            pw.println("TOTAL = Rp"
                    + pesanan.hitungTotal());

        } catch (IOException e) {
            System.out.println("Gagal menyimpan struk.");
        }
    }
}