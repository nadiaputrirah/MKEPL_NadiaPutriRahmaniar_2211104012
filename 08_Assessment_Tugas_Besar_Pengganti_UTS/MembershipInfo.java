import java.util.Date;

public class MembershipInfo {
    private String kodeAnggota;
    private Date tanggalGabung;
    private boolean statusAktif;
    private String tingkatKeanggotaan;

    public MembershipInfo(String kodeAnggota, Date tanggalGabung, boolean statusAktif, String tingkatKeanggotaan) {
        this.kodeAnggota = kodeAnggota;
        this.tanggalGabung = tanggalGabung;
        this.statusAktif = statusAktif;
        this.tingkatKeanggotaan = tingkatKeanggotaan;
    }
}
