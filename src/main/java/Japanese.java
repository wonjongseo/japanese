import java.util.ArrayList;
import java.util.List;

public class Japanese {
    private List<String> word = new ArrayList<>();
    private List<String> means = new ArrayList<>();
    private int totalCount;
    public List<String> getWord() {
        return word;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setWord(List<String> word) {
        this.word = word;
    }

    public List<String> getMeans() {
        return means;
    }

    public void setMeans(List<String> means) {
        this.means = means;
    }
}
