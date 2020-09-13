package nigeriandailies.com.ng.gads;

public class Skill_IQ_Response {
//    Email Address = entry.1824927963
//    Name = entry.1877115667
//    Last Name = entry.2006916086
//    Link to project = entry.284483984
    private String name;
    private String score;
    private String country;
    private String badgeUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBadgeUrl() {
        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {
        this.badgeUrl = badgeUrl;
    }

    @Override
    public String toString() {
        return "Skill_IQ_Response{" +
                "name='" + name + '\'' +
                ", hours=" + score +
                ", country='" + country + '\'' +
                ", badgeUrl='" + badgeUrl + '\'' +
                '}';
    }
}
