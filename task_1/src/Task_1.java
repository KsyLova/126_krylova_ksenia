public class Task_1 implements Task_1_base {
    @Override
    public int subtask_1_if(int first, int second, int third) {
        int min1;
        min1=0;
        if (first <second && first<third){
            min1=first;
        }
        else if (second<first&& second<third){
            min1=second;
        }
        else if (third<first && third<second){
            min1=third;

        }
        return min1 ;
    }

    @Override
    public boolean subtask_2_if(int year) {
        if (year % 4==0 && year%100!= 0) {
            return true;
        } else if (year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public int subtask_3_if(double x, double y, double left_up_x, double left_up_y, double width, double height) {
        if (width<=0 || height<=0) {
            return 2;
        }
        if (x>left_up_x &&(Math.abs(x-left_up_x)>0.000001) && y<left_up_y && (Math.abs(y-left_up_y)>0.000001) && x<(left_up_x+width) &&(Math.abs(x-(left_up_x+width))>0.000001) && y>(left_up_y-height) &&(Math.abs(y-(left_up_y-height))>0.000001) ){
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public int subtask_4_if(double x0, double y0, double k, double b) {
        if ((y0>x0*k+b) && (Math.abs((x0*k+b)-y0)>0.000001)){
            return 0;
        }
        else if ((y0<x0*k+b) && (Math.abs((x0*k+b)-y0)>0.000001)){
            return 1;
        }
        else {
            return 2;
        }
    }
    @Override
    public String subtask_5_switch(int day_od_week) {
        if (day_od_week == 1) {
            return "Понедельник";
        } else if (day_od_week == 2) {
            return "Вторник";
        } else if (day_od_week == 3) {
            return "Среда";
        } else if (day_od_week == 4) {
            return "Четверг";
        } else if (day_od_week == 5) {
            return "Пятница";
        } else if (day_od_week == 6) {
            return "Суббота";
        } else if (day_od_week == 7) {
            return "Воскресенье";
        } else {
            return "Ошибка";
        }
    }
    @Override
    public String subtask_6_switch(int direction) {
        switch (direction) {
            case 1:
                return "север";
            case 2:
                return "юг";
            case 3:
                return "запад";
            case 4:
                return "восток";
        }
        return "";
    }
    @Override
    public int subtask_7_if(double vx, double vy, double vz, double speed, double time, double wall) {
        if (speed <= 0 || time <= 0) {
            return 2;
        } 
        else {
            if (vx != 0) {
                double y1 = vy * (wall / vx);
                double x1 = vx * (wall / vx);
                double len = Math.sqrt(y1 * y1 + x1 * x1 + wall * wall);
                if (Math.abs(len / speed - time) > 0.000001) {
                    return 0;
                } else {
                    return 1;
                }
            }
            return 0;
        }
    }
    @Override
    public int subtask_8_if(double k1, double b1, double k2, double b2) {
        if (b1 == b2 && k1 == k2) {
            return 3;
        } else if (k1 == k2 && b1 != b2) {
            return 1;
        } else if (b1 != b2 && k1 != k2) {
            return 2;
        }
        return 0;
    }
}
