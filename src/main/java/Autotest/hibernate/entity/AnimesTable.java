package Autotest.hibernate.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "animes")
@Component("anime")
public class AnimesTable implements DBInterface {
    @Column(name = "id")
    @Id
    private int id;
    @Column(name = "name")
    private String animeName;

    @Column(name = "episodes")
    private int episodes;

    @Column(name = "russian")
    private String russianName;

    @Column(name = "score")
    private float animeScore;

    public AnimesTable(String animeName, int episodes, String russianName, float animeScore) {
        this.animeName = animeName;
        this.episodes = episodes;
        this.russianName = russianName;
        this.animeScore = animeScore;
    }

    public AnimesTable() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimeName() {
        return animeName;
    }

    public void setAnimeName(String animeName) {
        this.animeName = animeName;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public String getRussianName() {
        return russianName;
    }

    public void setRussianName(String russianName) {
        this.russianName = russianName;
    }

    public float getAnimeScore() {
        return animeScore;
    }

    public void setAnimeScore(float animeScore) {
        this.animeScore = animeScore;
    }

    @Override
    public String toString() {
        return "AnimesTable{" +
                "id=" + id +
                ", animeName='" + animeName + '\'' +
                ", episodes=" + episodes +
                ", russianName='" + russianName + '\'' +
                ", animeScore=" + animeScore +
                '}';
    }
}
