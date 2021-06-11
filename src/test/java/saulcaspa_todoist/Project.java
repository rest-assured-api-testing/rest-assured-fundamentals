package saulcaspa_todoist;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(fluent = true)
public class Project {
    public String name;
    public boolean favorite;
    public int color;
    public boolean shared;
}
