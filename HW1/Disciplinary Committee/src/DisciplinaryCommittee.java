import java.util.*;

public class DisciplinaryCommittee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        HashMap<String, String> list = new HashMap<>();

        String playersNames;

        for (int i=0; i < n; i++){
            playersNames = scanner.nextLine();
            list.put(playersNames, null);
        }


        List<String> bannedTeams = new ArrayList<>();

        String teamName;
        int numberOfMembers;
        String membersNames;

        for (int i=0; i<m; i++){
            teamName = scanner.nextLine();
            numberOfMembers = scanner.nextInt();
            scanner.nextLine();
            for (int k=0; k<numberOfMembers; k++){
                membersNames = scanner.nextLine();

                if (!list.containsKey(membersNames)){
                    bannedTeams.add(teamName);
                }
                if (list.get(membersNames) != null ){
                    bannedTeams.add(teamName);
                    bannedTeams.add(list.get(membersNames));
                }
                list.put(membersNames, teamName);
            }

        }

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.addAll(bannedTeams);
        bannedTeams.clear();
        bannedTeams.addAll(lhs);

        Collections.sort(bannedTeams);
        for(int i = 0; i < bannedTeams.size(); i++) {
            System.out.println(bannedTeams.get(i));
        }
    }
}