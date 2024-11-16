package menu.domain;

import java.util.List;
import java.util.Objects;

public class Coaches {

    private final List<Coach> coachGroup;

    public Coaches(final List<Coach> coachGroup) {
        validate(coachGroup);
        this.coachGroup = coachGroup;
    }

    private void validate(List<Coach> coachGroup) {
        if (coachGroup.size() < 2 || coachGroup.size() > 5) {
            throw new IllegalArgumentException("[ERROR] 코치는 최소 2명 이상 5명 이하여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Coaches coaches)) {
            return false;
        }
        return Objects.equals(coachGroup, coaches.coachGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coachGroup);
    }
}
