import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Task_5 implements Task_5_base {
    @Override
    public ArrayList<Integer> subtask_1_ArrayList(ArrayList<Integer> data, int k, int n) {
        // Выбрать из данного списка элементы, кратные k, но не кратные n
        // и сформировать из них новый список.
        // Вернуть новый список в качестве результата
        ArrayList<Integer> intArrList = new ArrayList<>();

        for(int i = 0; i < data.size(); i++){
            if(data.get(i) % k == 0 && data.get(i) % n != 0){
                intArrList.add(data.get(i));
            }
        }
        return intArrList;
    }

    @Override
    public ArrayList<Integer> subtask_2_ArrayList(int size) {
        // сгенерировать и вернуть список размера size,
        // содержащий первые size элементов последовательности, описанной в
        // задаче subtask_2_for задания task_3
        ArrayList<Integer> newArr= new ArrayList<>();

        for (int j=0,i=1; j<size; i++){
            for(int k=0;j<size && k<i;k++) {
                newArr.add(i);
                j++;
            }
        }
        return newArr;
    }

    @Override
    public HashSet<Integer> subtask_3_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите пересечение множеств s1 и s2
        s1.retainAll(s2);
        return s1;
    }

    @Override
    public HashSet<Integer> subtask_4_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите объединение множеств s1 и s2
        s1.addAll(s2);
        return s1;
    }

    @Override
    public HashSet<Integer> subtask_5_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // найдите дополнение множества s1 до множества s2
        HashSet<Integer> type= new HashSet<Integer>();
        for (int j:s2){
            if (!s1.contains(j)) type.add(j);
        }
        return type;
    }


    @Override
    public HashSet<Integer> subtask_6_HashSet(HashSet<Integer> s1, HashSet<Integer> s2) {
        // постройте множество, содержащее элементы, содержащиеся либо только в s1,
        // либо только в s2, но не в обоих множествах одновременно
        HashSet<Integer> newSet= new HashSet<>();
        HashSet<Integer> retainSet= new HashSet<>();

        retainSet.addAll(s1);
        retainSet.retainAll(s2);

        s1.removeAll(retainSet);
        s2.removeAll(retainSet);

        newSet.addAll(s1);
        newSet.addAll(s2);
        return newSet;
    }

    @Override
    public HashMap<String, Double> subtask_7_HashMap(ArrayList<String> data) {
        // Дан список строк. Построить словарь, содержащий частоты слов
        // для данного списка в процентах
        HashMap<String,Double> type = new HashMap<>();
        double r;
        for (int i =0;i < data.size();i++) {
            r = 0;
            for(int j=0;j< data.size(); j++) {
                if (data.get(i) == data.get(j)) r++;
            }
            type.put(data.get(i), r/data.size()*100);
        }
        return type;
    }

    @Override
    public HashMap<String, Double> subtask_8_HashMap(ArrayList<Double> data) {
        // Дан список чисел. Сформировать словарь, содержащий среднее,
        // максимальное и минимальное значения из данного списка. Ключи
        // словаря "mean", "max", "min" соответственно
        HashMap<String,Double> type = new HashMap<>();
        double min1,max1,mean1;
        min1=data.get(0);
        max1=data.get(0);
        mean1=0;
        for (int i=0;i<data.size();i++){
            if (min1>data.get(i)) min1=data.get(i);
            if (max1<data.get(i)) max1=data.get(i);
            mean1+=data.get(i);
        }
        mean1=mean1/data.size();
        type.put("mean",mean1);
        type.put("max",max1);
        type.put("min",min1);
        return type;
    }
}
