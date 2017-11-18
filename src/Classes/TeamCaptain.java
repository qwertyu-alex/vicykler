package Classes;//Alexander Van Le && Oliver Lange

import Actions.SearchForParticipant;
import java.util.ArrayList;

public class TeamCaptain extends Participant {
    //Constructor
    public TeamCaptain(Participant participant){
        super(participant);
    }

    public TeamCaptain(String name, String email, String password, String cyclistType){
        super(name, email, password, cyclistType);
    }

    @Override
    public void setTeam(Team team) {
        super.setTeam(team);
        if (team.getTeamCaptain() != this){
            team.setTeamCaptain(this);
        }
    }
}
