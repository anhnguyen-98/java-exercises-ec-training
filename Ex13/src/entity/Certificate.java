package entity;

import java.time.LocalDate;

public class Certificate {
    private static int count = 0;
    private int certificateID;
    private String certificateName;
    private String certificateRank;
    private LocalDate certificateDate;

    public Certificate(String certificateName, String certificateRank, LocalDate certificateDate) {
        this.certificateID = ++count;
        this.certificateName = certificateName;
        this.certificateRank = certificateRank;
        this.certificateDate = certificateDate;
    }

    public int getCertificateID() {
        return certificateID;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateRank() {
        return certificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        this.certificateRank = certificateRank;
    }

    public LocalDate getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(LocalDate certificateDate) {
        this.certificateDate = certificateDate;
    }
}
