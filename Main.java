import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Menu menu = new Menu();
        Pesanan pesanan = new Pesanan();

        int pilihan;

        do {

            System.out.println("\n===== RESTORAN =====");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Tampilkan Menu");
            System.out.println("3. Pesan");
            System.out.println("4. Hitung Total");
            System.out.println("5. Tampilkan Struk");
            System.out.println("6. Simpan Menu");
            System.out.println("7. Simpan Struk");
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:

                    System.out.println("1. Makanan");
                    System.out.println("2. Minuman");
                    System.out.println("3. Diskon");

                    int jenis = input.nextInt();
                    input.nextLine();

                    if (jenis == 1) {

                        System.out.print("Nama : ");
                        String nama = input.nextLine();

                        System.out.print("Harga : ");
                        double harga = input.nextDouble();
                        input.nextLine();

                        System.out.print("Jenis makanan : ");
                        String jm = input.nextLine();

                        menu.tambahItem(
                                new Makanan(nama,
                                        harga,
                                        jm));

                    } else if (jenis == 2) {

                        System.out.print("Nama : ");
                        String nama = input.nextLine();

                        System.out.print("Harga : ");
                        double harga = input.nextDouble();
                        input.nextLine();

                        System.out.print("Jenis minuman : ");
                        String jm = input.nextLine();

                        menu.tambahItem(
                                new Minuman(nama,
                                        harga,
                                        jm));

                    } else {

                        System.out.print("Nama diskon : ");
                        String nama = input.nextLine();

                        System.out.print("Persentase : ");
                        double diskon =
                                input.nextDouble();

                        menu.tambahItem(
                                new Diskon(
                                        nama,
                                        diskon));
                    }

                    break;

                case 2:
                    menu.tampilkanMenu();
                    break;

                case 3:

                    menu.tampilkanMenu();

                    System.out.print(
                            "Pilih nomor menu : ");

                    int nomor = input.nextInt();

                    try {

                        pesanan.tambahPesanan(
                                menu.getItem(
                                        nomor - 1));

                        System.out.println(
                                "Pesanan berhasil ditambahkan.");

                    } catch (Exception e) {

                        System.out.println(
                                e.getMessage());
                    }

                    break;

                case 4:

                    System.out.println(
                            "Total = Rp"
                                    + pesanan.hitungTotal());

                    break;

                case 5:

                    pesanan.tampilStruk();

                    break;

                case 6:

                    FileManager.simpanMenu(
                            menu.getDaftarMenu(),
                            "menu.txt");

                    System.out.println(
                            "Menu berhasil disimpan.");

                    break;

                case 7:

                    FileManager.simpanStruk(
                            pesanan,
                            "struk.txt");

                    System.out.println(
                            "Struk berhasil disimpan.");

                    break;

                case 0:

                    System.out.println(
                            "Terima kasih.");

                    break;

                default:

                    System.out.println(
                            "Pilihan tidak valid.");
            }

        } while (pilihan != 0);
    }
}