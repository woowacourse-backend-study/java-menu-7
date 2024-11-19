package menu.domain;

import static menu.util.enums.Delimiter.COMMA;

import java.util.List;
import java.util.Objects;
import menu.domain.vo.Menu;

public class Coach {

    private final CoachName coachName;
    private final UnEatingMenus unEatingMenus;
    private final RecommendationMenus recommendationMenus;

    public Coach(CoachName coachName, UnEatingMenus unEatingMenus, RecommendationMenus recommendationMenus) {
        this.coachName = coachName;
        this.unEatingMenus = unEatingMenus;
        this.recommendationMenus = recommendationMenus;
    }

    public static Coach from(String input) {
        return new Coach(
                CoachName.from(input),
                UnEatingMenus.create(),
                RecommendationMenus.create()
        );
    }

    public void registerUnEatingMenus(String input) {
        String[] split = input.strip().split(COMMA.getDelimiter(), -1);
        for (String inputMenu : split) {
            unEatingMenus.addUnEatingMenu(Menu.from(inputMenu));
        }
    }

    public void registerRecommendationMenu(Menu menu) {
        recommendationMenus.addRecommendationMenus(menu);
    }

    public boolean checkRecommended(Menu menu) {
        return !unEatingMenus.isContain(menu) && !recommendationMenus.isDuplicate(menu);
    }

    public String getCoachName() {
        return coachName.getCoachName();
    }


    public List<Menu> getRecommendationMenus() {
        return recommendationMenus.getRecommendationMenus();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coach coach = (Coach) o;
        return Objects.equals(coachName, coach.coachName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coachName);
    }

    @Override
    public String toString() {
        return coachName.toString();
    }
}
