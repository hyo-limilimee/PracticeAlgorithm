import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        
        Map<String, Integer> parkingInfos = new HashMap<>();
        Map<String, Integer> entryTimes = new HashMap<>();
        
        for (String record : records) {
            String[] splitRecord = record.split(" ");
            String[] time = splitRecord[0].split(":");
            int timeInMin = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            String carNum = splitRecord[1];
            String state = splitRecord[2];
            
            if (state.equals("IN")) {
                entryTimes.put(carNum, timeInMin);
            } else {
                int entryTime = entryTimes.get(carNum);
                int totalTime = timeInMin - entryTime;
                parkingInfos.put(carNum, parkingInfos.getOrDefault(carNum, 0) + totalTime);
                entryTimes.remove(carNum);
            }
        }
        
        for (String carNum : entryTimes.keySet()) {
            int entryTime = entryTimes.get(carNum);
            int finalTime = 23 * 60 + 59; 
            int totalTime = finalTime - entryTime;
            parkingInfos.put(carNum, parkingInfos.getOrDefault(carNum, 0) + totalTime);
        }
        
        List<String> sortedCarNums = new ArrayList<>(parkingInfos.keySet());
        Collections.sort(sortedCarNums);
        
        int[] answer = new int[sortedCarNums.size()];
        for (int i = 0; i < sortedCarNums.size(); i++) {
            String carNum = sortedCarNums.get(i);
            int totalTime = parkingInfos.get(carNum);
            
            if (totalTime <= basicTime) {
                answer[i] = basicFee;
            } else {
                int extraTime = totalTime - basicTime;
                int extraUnits = (int) Math.ceil(extraTime / (double) unitTime);
                answer[i] = basicFee + extraUnits * unitFee;
            }
        }
        
        return answer;
    }
}
