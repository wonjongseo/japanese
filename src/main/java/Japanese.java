import java.util.ArrayList;
import java.util.List;

public class Japanese {
    private List<String> kanji = new ArrayList<>();
    private List<String> means = new ArrayList<>();
    private List<String> hiragana = new ArrayList<>();

    private int totalCount;

    public List<String> getKanji() {
        return kanji;
    }

    public void setKanji(List<String> kanji) {
        this.kanji = kanji;
    }

    public List<String> getHiragana() {
        return hiragana;
    }

    public void setHiragana(List<String> hiragana) {
        this.hiragana = hiragana;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }


    public List<String> getMeans() {
        return means;
    }

    public void setMeans(List<String> means) {
        this.means = means;
    }
}
