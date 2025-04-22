public class LibraryMember {
    private static final double BOBOT_TERLAMBAT = 1.5;
    private static final double BOBOT_DENDA = 0.1;
    private static final double PENALTI_NONAKTIF = 5.0;
    private static final double PENALTI_DASAR = 2.0;
    private static final double BONUS_BUKU_BANYAK = -1.5;

    private PersonalInfo personalInfo;
    private MembershipInfo membershipInfo;
    private ActivityStats activityStats;

    private String kodeReferal;
    private boolean langgananBuletin;

    public LibraryMember(PersonalInfo personalInfo, MembershipInfo membershipInfo, ActivityStats activityStats,
                         String kodeReferal, boolean langgananBuletin) {
        this.personalInfo = personalInfo;
        this.membershipInfo = membershipInfo;
        this.activityStats = activityStats;
        this.kodeReferal = kodeReferal;
        this.langgananBuletin = langgananBuletin;
    }

    public void cetakProfilLengkap() {
        System.out.println("===== PROFIL ANGGOTA =====");
        // Cetak info pribadi
        System.out.println("Nama            : " + personalInfo.getNamaLengkap());
        System.out.println("Jenis Kelamin   : " + personalInfo.getJenisKelamin());
        System.out.println("Alamat          : " + personalInfo.getAlamat());
        System.out.println("Telepon         : " + personalInfo.getNomorTelepon());
        System.out.println("Email           : " + personalInfo.getEmail());

        // Cetak info keanggotaan
        System.out.println("Kode Anggota    : " + membershipInfo.getKodeAnggota());
        System.out.println("Tanggal Gabung  : " + membershipInfo.getTanggalGabung());
        System.out.println("Status Aktif    : " + membershipInfo.isStatusAktif());
        System.out.println("Tingkat         : " + membershipInfo.getTingkatKeanggotaan());

        // Cetak info aktivitas
        System.out.println("Buku Dipinjam   : " + activityStats.getJumlahBukuDipinjam());
        System.out.println("Terlambat       : " + activityStats.getJumlahTerlambat());
        System.out.println("Denda           : Rp " + activityStats.getJumlahDenda());
        System.out.println("Poin            : " + activityStats.getPoinLoyalitas());
        System.out.println("Kode Referal    : " + kodeReferal);
        System.out.println("Langganan Buletin: " + langgananBuletin);
        System.out.println("Skor Risiko     : " + hitungSkorRisiko());
        System.out.println("Layak Upgrade?  : " + periksaKelayakanUpgrade());
        System.out.println("===========================");
    }

    public double hitungSkorRisiko() {
        double skor = 0;
        skor += activityStats.getJumlahTerlambat() * BOBOT_TERLAMBAT;
        skor += activityStats.getJumlahDenda() * BOBOT_DENDA;
        if (!membershipInfo.isStatusAktif()) skor += PENALTI_NONAKTIF;
        if (membershipInfo.getTingkatKeanggotaan().equals("DASAR")) skor += PENALTI_DASAR;
        if (activityStats.getJumlahBukuDipinjam() > 50) skor += BONUS_BUKU_BANYAK;
        return skor;
    }

    public boolean periksaKelayakanUpgrade() {
        return membershipInfo.getTingkatKeanggotaan().equals("DASAR")
                && activityStats.getPoinLoyalitas() > 100;
    }
}