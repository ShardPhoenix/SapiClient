package au.com.sensis.sapi.responsemodel;

public class ListingBusinessInfo {

    private String legalId;
    private String abn;
    private String acn;
    private String numberOfEmployees;
    private String dateEstablished;

    public ListingBusinessInfo(String legalId, String abn, String acn, String numberOfEmployees, String dateEstablished) {
        this.legalId = legalId;
        this.abn = abn;
        this.acn = acn;
        this.numberOfEmployees = numberOfEmployees;
        this.dateEstablished = dateEstablished;
    }

    public ListingBusinessInfo() {
    }

    public String getLegalId() {
        return legalId;
    }

    public void setLegalId(String legalId) {
        this.legalId = legalId;
    }

    public String getAbn() {
        return abn;
    }

    public void setAbn(String abn) {
        this.abn = abn;
    }

    public String getAcn() {
        return acn;
    }

    public void setAcn(String acn) {
        this.acn = acn;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getDateEstablished() {
        return dateEstablished;
    }

    public void setDateEstablished(String dateEstablished) {
        this.dateEstablished = dateEstablished;
    }

}
