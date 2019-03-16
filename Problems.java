package package_Pragma;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Problems {
	
	static CSVUtils csvutils = new CSVUtils();
	static String dir_path = "/home/ajay/Documents/my_workspace/Java/PragmaData/DataSet/";
	
	public static void problem1()
	{
		List<Object> records = csvutils.read_csv(dir_path, "matches");
		
		TreeMap<String, Integer> count_map = new TreeMap<>();
		for(Object record: records)
		{			
			Matches_attrib matches_rec = (Matches_attrib)record;
			int season = matches_rec.getSeason();
			String toss_winner = matches_rec.getToss_winner();
			String decision = matches_rec.getToss_decision();
			
			if(season == 2017 || season==2016)
			{
				if(decision.equals("field"))
				{
					String key = season+"\t"+toss_winner;
					int count =  count_map.getOrDefault(key, 0);
					count_map.put(key, count+1);
				}
			}
			
		}
		
		Comparator<Entry<String, Integer>> sortByValueComparator = new Comparator<Entry<String, Integer>>()
		{

				@Override
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					int value1 = o1.getValue();
					int value2 = o2.getValue();
					
					return value2-value1;
				}
			
		};
		
		Set<Entry<String, Integer>> entries = count_map.entrySet();
		
		List<Entry<String, Integer>> list_entries = new ArrayList<>(entries);
		Collections.sort(list_entries, sortByValueComparator);
		int count = 4;
		System.out.printf("%-26s%10s\n","Season    Team", "Count");		
		for(Entry<String, Integer> entry:list_entries)
		{
			if(count>0)
				System.out.printf("%-26s%5d\n",entry.getKey(),entry.getValue());
			count--;
		}
	}
	
	public static void problem2()
	{
		List<Object> records = csvutils.read_csv(dir_path, "matches");
		
		TreeMap<Integer, Integer> matchid_season_map = new TreeMap<>();
		for(Object record: records)
		{			
			Matches_attrib matches_rec = (Matches_attrib)record;
			matchid_season_map.put(matches_rec.getMatch_id(), matches_rec.getSeason());
		}
		
		records = csvutils.read_csv(dir_path, "deliveries");
		ArrayList<Integer> stats; // ArrayList = [4_Count, 6_Count, Total_Score]
		TreeMap<String, ArrayList<Integer>> output_records = new TreeMap<String, ArrayList<Integer>>();
		
		for(Object record: records)
		{			
			Deliveries_attrib deliveries_rec = (Deliveries_attrib)record;
			int match_id = deliveries_rec.getMatch_id();
			int season  = matchid_season_map.get(match_id);
			String bowler = deliveries_rec.getBatting_team();
			String key = season+"\t"+bowler;
			
			if(output_records.containsKey(key) == false)
			{
				ArrayList<Integer> value = new ArrayList<>(3);
				value.add(0);
				value.add(0);
				value.add(0);
				output_records.put(key,value);
				
			}
			
			stats = output_records.get(key);
			if(deliveries_rec.getBatsman_runs()==4)
				stats.set(0,stats.get(0)+1);
			else if (deliveries_rec.getBatsman_runs()==6)
				stats.set(1,stats.get(1)+1);
			stats.set(2,stats.get(2)+deliveries_rec.getTotal_runs());
			
		}
		Set<Entry<String, ArrayList<Integer>>> entries = output_records.entrySet();
		System.out.printf("%-35s%8s%7s%12s\n", "Season\tTeam", "Fours", "Sixes","Total Runs");
		for(Entry<String, ArrayList<Integer>> entry : entries)
		{
			stats = entry.getValue();
			String key = entry.getKey();			
			System.out.printf("%-35s%5d%7d%10d\n", key, stats.get(0), stats.get(1),stats.get(2));
		}
	}
	
	public static void problem3()
	{
		List<Object> records = csvutils.read_csv(dir_path, "matches");
		
		TreeMap<Integer, Integer> matchid_season_map = new TreeMap<>();
		for(Object record: records)
		{			
			Matches_attrib matches_rec = (Matches_attrib)record;
			matchid_season_map.put(matches_rec.getMatch_id(), matches_rec.getSeason());
		}
		
		records = csvutils.read_csv(dir_path, "deliveries");
		
		TreeMap<String, Integer> bowler_runs_map = new TreeMap<String, Integer>();
		TreeMap<String, Set<String>> bowler_overs_map = new TreeMap<String, Set<String>>(); 
		
		Set<String> matches_count;
		
		for(Object record: records)
		{			
			Deliveries_attrib deliveries_rec = (Deliveries_attrib)record;
			int match_id = deliveries_rec.getMatch_id();
			int season  = matchid_season_map.get(match_id); // from match id extracting season 
			String bowler = deliveries_rec.getBowler();
			int over = deliveries_rec.getOver();
			
			String key = season+"\t"+bowler;
			
			String value = match_id+" "+over;
			int runs = deliveries_rec.getTotal_runs()-deliveries_rec.getBye_runs()-deliveries_rec.getLegby_runs();
			
			if(bowler_overs_map.containsKey(key)== false)
			{
				bowler_runs_map.put(key,0);
				matches_count = new HashSet<String>();
				bowler_overs_map.put(key, matches_count);
				
			}
			
			runs= bowler_runs_map.get(key)+runs;
			bowler_runs_map.put(key, runs);
			bowler_overs_map.get(key).add(value);			
			
		}
		
		Set<Entry<String, Set<String>>> entries_overs = bowler_overs_map.entrySet();
		
		System.out.printf("%2s%32s\n","Year\tPlayer","Economy");
		for(Entry<String, Set<String>> entry: entries_overs)
		{
			if(entry.getValue().size()>=10) // Checking overs > 10 : True or False
			{
				float economy = bowler_runs_map.get(entry.getKey())/(float)entry.getValue().size();
				System.out.printf("%-35s%5f\n",entry.getKey(),economy);
			}
		}
		
	}

	public static void problem4()
	{
		List<Object> records = csvutils.read_csv(dir_path, "matches");
		
		TreeMap<Integer, String[]> matchid_season_map = new TreeMap<>();
		for(Object record: records)
		{			
			Matches_attrib matches_rec = (Matches_attrib)record;
			String args[] = {matches_rec.getSeason()+"", matches_rec.getTeam1(), matches_rec.getTeam2()};
			matchid_season_map.put(matches_rec.getMatch_id(), args); // Maping Match_id with season
		}
		
		records = csvutils.read_csv(dir_path, "deliveries");
		
		TreeMap<String, Integer> runs_scored = new TreeMap<String, Integer>();
		TreeMap<String, Set<String>> overs_faced = new TreeMap<String, Set<String>>(); 
		TreeMap<String, Integer> runs_conceded = new TreeMap<String, Integer>();
		TreeMap<String, Set<String>> overs_bowled = new TreeMap<String, Set<String>>(); 
	
		Set<String> set_overs; // stores set of overs 
		
		for(Object record: records)
		{			
			Deliveries_attrib deliveries_rec = (Deliveries_attrib)record;
			int match_id = deliveries_rec.getMatch_id();
			String season  = matchid_season_map.get(match_id)[0]; // from match id extracting season 
			String team1 = matchid_season_map.get(match_id)[1];
			String team2 = matchid_season_map.get(match_id)[2];
			
			String batting_team = deliveries_rec.getBatting_team();
						
			int over = deliveries_rec.getOver();
			
			String key1 = season+"\t"+team1; // key for run_scored Map
			String key2 = season+"\t"+team2; // Key for run_conceded Map
			
			String over_key = match_id+" "+over;       // unique id for every over i.e. match_id+over
			int runsperball = deliveries_rec.getTotal_runs();
			
			if(team1 == batting_team)
			{
				if(runs_scored.containsKey(key1)== false)
				{
					runs_scored.put(key1, 0);
					overs_faced.put(key1, new HashSet<String>());
				}
				if(runs_conceded.containsKey(key2) == false)
				{
					runs_conceded.put(key2, 0);
					overs_bowled.put(key2, new HashSet<String>());
					
				}
				
				runs_scored.put(key1, runs_scored.get(key1)+runsperball);
				set_overs = overs_faced.get(key1);
				set_overs.add(over_key);
				
				runs_conceded.put(key2, runs_conceded.get(key2)+runsperball);
				set_overs = overs_bowled.get(key2);
				set_overs.add(over_key);
			}
			
			else
			{
				
				if(runs_scored.containsKey(key2)== false)
				{
					runs_scored.put(key2, 0);
					overs_faced.put(key2, new HashSet<String>());
				}
				if(runs_conceded.containsKey(key1) == false)
				{
					runs_conceded.put(key1, 0);
					overs_bowled.put(key1, new HashSet<String>());
					
				}
				
				runs_scored.put(key2, runs_scored.get(key2)+runsperball);
				set_overs = overs_faced.get(key2);
				set_overs.add(over_key);
				
				runs_conceded.put(key1, runs_conceded.get(key1)+runsperball);
				set_overs = overs_bowled.get(key1);
				set_overs.add(over_key);
				
			}
			
		}
		
		TreeMap<String, Float> runrate_table = new TreeMap<>();
		
		Set<Entry<String, Integer>> entries  = runs_scored.entrySet();
		for(Entry<String,Integer> entry : entries)
		{
			String key = entry.getKey();
			float runrate = (entry.getValue()/(float)overs_faced.get(key).size())-(runs_conceded.get(key)/(float)overs_bowled.get(key).size());
			runrate_table.put(key, runrate);
		}
		
		//Logic for arranging team runrate per year 
		
		TreeMap<String,Set<Entry<String,Float>>> forsorting = new TreeMap<String,Set<Entry<String,Float>>>();
		
		Set<Entry<String, Float>> runrate_entries = runrate_table.entrySet();
		for(Entry<String, Float> entry : runrate_entries)
		{
			String season = entry.getKey().substring(0, 4);
			Set<Entry<String, Float>> entry_set = forsorting.getOrDefault(season,new HashSet<Entry<String, Float>>());
			entry_set.add(entry);
			forsorting.put(season, entry_set);
		}
		//System.out.println(forsorting);
		
		LinkedHashMap< String, Float> final_output = new LinkedHashMap<>();
		 for(Entry<String,Set<Entry<String,Float>>> entry : forsorting.entrySet())
		 {
			 runrate_entries = entry.getValue();
			 List<Entry<String,Float>> temp = new ArrayList<>(runrate_entries);
			 
			 Comparator<Entry<String,Float>> compareByValue = new Comparator<Map.Entry<String,Float>>() {

				@Override
				public int compare(Entry<String, Float> arg0, Entry<String, Float> arg1) {
					
					return (int)(arg1.getValue()-arg0.getValue())*1000;
				}
				 
			};
			
			Collections.sort(temp, compareByValue);
			final_output.put(temp.get(0).getKey(), temp.get(0).getValue());
		 }
		 
		 System.out.printf("%-20s%28s\n","Season\tTeam","Net Runrate");
		 for (Entry<String, Float> entry:final_output.entrySet())
		 {
			 System.out.printf("%-36s%5f\n",entry.getKey(), entry.getValue());
		 }
	}
	
	
	public static void main(String args[])
	{
		problem1();
		System.out.println();
		problem2();
		System.out.println();
		problem3();
		System.out.println();
		problem4();
		
				
	}
}
