package Classes;//Alexander Van Le && Oliver Langeee

import Actions.SearchForParticipant;
import java.util.ArrayList;

public class TeamCaptain extends Participant {
    //Constructor
    public TeamCaptain(Participant participant){
        super(participant);

        //fjern personen fra deltager listen og gør ham i stedet for til en holdkaptain
        participant.removePerson(participant);
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


    public void removeParticipant(){
        ArrayList<Participant> participantsInTheTeam = this.getTeam().getParticipants();

        //tjek hvis der er deltagere i holdet
        if (participantsInTheTeam.size() > 0){
            System.out.println("Emailliste over folk på holdet:");
            for (Participant participant: participantsInTheTeam ) {
                if (participant != this){
                    System.out.println(participant.getEmail());
                }
            }

            //Tjek om emailen er i listen participantsInTheTeam
            Participant foundParticipant = (new SearchForParticipant().run(participantsInTheTeam));

            //Fjern participant
            if (foundParticipant != null){
                System.out.println("Deltager, " + foundParticipant.getName() + ", er fjernet fra listen");
                foundParticipant.removeParticipant();
                foundParticipant = null;
            } else {
                System.out.println("Ingen personer er fjernet fra holdet");
            }

        } else{
            //hvis der ikke er nogen deltagere
            System.out.println("Ingen deltagere i holdet");
        }
    }
}
