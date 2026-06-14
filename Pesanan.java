import java.util.ArrayList;

public class Pesanan {
    private ArrayList<MenuItem> daftarPesanan;

    public Pesanan() {
        daftarPesanan = new ArrayList<>();
    }

    public void tambahPesanan(MenuItem item) {
        daftarPesanan.add(item);
    }

    public double hitungTotal() {
        double total = 0;
        double diskon = 0;

        for (MenuItem item : daftarPesanan) {

            if (item instanceof Diskon) {
                diskon = ((Diskon) item).getDiskon();
            } else {
                total += item.getHarga();
            }
        }

        total = total - (total * diskon / 100);

        return total;
    }

    public void tampilStruk() {

        System.out.println("\n===== STRUK =====");

        for (MenuItem item : daftarPesanan) {
            item.tampilMenu();
        }

        System.out.println("----------------");
        System.out.println("TOTAL : Rp" + hitungTotal());
    }

    public ArrayList<MenuItem> getDaftarPesanan() {
        return daftarPesanan;
    }
}