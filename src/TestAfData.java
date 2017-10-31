import java.util.ArrayList;

public class TestAfData {


    public void testData() {
        Data data = new Data();
        data.generateData();
        ArrayList<Participant> participants = data.getParticipants();
        ArrayList<Firm> firms = data.getFirms();
        ArrayList<Team> teams = data.getTeams();




        System.out.printf("%-5s %-25s %-15s %-25s %-35s %-20s", "Nr:", "Navn:", "Cykel type:", "Email:", "Hold:", "Firma");

        int i = 0;
        int t = 0;
        int f = 0;
        int t1 = 0;

        for (Participant participant : participants) {
            System.out.printf("\n%-5d %-25s %-15s %-25s %-35s %-20s", i + 1, participants.get(i).getParticipantName(), participants.get(i).getCyclistType(), participants.get(i).getParticipantEmail(), participants.get(i).getTeam().getTeamName(), participants.get(i).getFirm().getFirmName());

            i++;
            //************Skal laves på en bedre måde, da man ikke kan regne med hold og firmaer på præcis 5 og 10 deltagere******************
            //evt noget med team size

//            if (i % 5 == 0)
//                t++;
//            if (i % 10 == 0)
//                f++;
            //*********************************************************************************************************************************
        }
    }
}
