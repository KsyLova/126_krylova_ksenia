public class Task_1 implements Task_1_base {
    @Override
    public int subtask_1_if(int first, int second, int third) {
        // Вычислить и вернуть минимальный из трех полученных аргументов (first, second, third)
        // ------------------------------------------------------------------------------------
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
        // Проверить, является ли год, переданный в параметре year, високосным.
        // Високосный год - это год, кратный четырем, но не кратный 100, либо кратный 400
        // ------------------------------------------------------------------------------------
        if (year % 4==0 && year%100!= 0) {
            return true;
        } else if (year % 400 == 0) {
            return true;
        } else {
        return false; // Замените данный оператор кодом, решающим поставленную задачу.
    }
    }
    @Override
    public int subtask_3_if(double x, double y, double left_up_x, double left_up_y, double width, double height) {
        // Проверить, лежит ли точка с координатами (x, y) внутри невырожденного квадрата
        // со сторонами, параллельными осям координат, левый верхний угол которого имеет
        // координаты (left_up_x, left_up_y), ширина которого width, высота height.
        // Точка на границе считается не лежащей внутри.
        // В качестве результата вернуть:
        // 0 - не лежит
        // 1 - лежит
        // 2 - аргументы функции заданы некорректно
        // Допустимой погрешностью при сравнении переменных типа double считать 0.000001
        // ------------------------------------------------------------------------------------
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
        // Проверить, как расположена точка с координатами (x0, y0)
        // относительно прямой y = kx + b
        // В качестве результата вернуть:
        // 0 - лежит выше прямой
        // 1 - лежит ниже прямой
        // 2 - лежит на прямой
        // Допустимой погрешностью при сравнении переменных типа double считать 0.000001
        // ------------------------------------------------------------------------------------
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
        // По номеру дня недели day_od_week вернуть его название на русском языке, записанное
        // с большой буквы. Дни едели отсчитываются с единицы. Если номер задан некорректно,
        // вернуть строку "Ошибка"
        // ------------------------------------------------------------------------------------
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
        // По заданному направлению direction вернуть его название:
        // 1 - север
        // 2 - юг
        // 3 - запад
        // 4 - восток
        // Во всех остальных случаях вернуть пустую строку
        // ------------------------------------------------------------------------------------
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
        // Проверить, достигнет ли снаряд, летяший из точки (0, 0, 0)
        // в направлении (vx, vy, vz) со скоростью speed стены, параллельной плоскости OYZ,
        // имеющей координату x равной wall, за время time
        // 0 - не достигнет
        // 1 - достигнет
        // 2 - аргументы функции заданы некорректно
        // Допустимой погрешностью при сравнении переменных типа double считать 0.000001
        // ------------------------------------------------------------------------------------
        if(time>0.000001 && speed>0.000001){
            if((Math.sqrt(wall*wall+vy*wall/vx*vy*wall/vx+vz*wall/vx*vz*wall/vx))/speed<=time){
                return 1;
            }
            else if(Math.abs((Math.sqrt(wall*wall+vy*wall/vx*vy*wall/vx+vz*wall/vx*vz*wall/vx))/speed-time)<0.000001){
                return 1;
            }
            else{
                return 0;
            }
        }
        else{
            return 2;
        }
    }
    @Override
    public int subtask_8_if(double k1, double b1, double k2, double b2) {
        // Проверить, как друг относительно друга располагаются прямые y = k1*x + b1 и
        // y = k2*x + b2. Вернуть
        // 1 - если параллельны
        // 2 - если пересекаются
        // 3 - если совпадают
        // Допустимой погрешностью при сравнении переменных типа double считать 0.000001
        // ------------------------------------------------------------------------------------
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
