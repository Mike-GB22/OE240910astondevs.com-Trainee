//2024.09.30 zip
// Класс обертка для доступа к внутренним функциям, которые не должны быть доступны пользователю
//но необходимы для проверки теста
public class MyArrayListWrapper<E>{
    public MyArrayList<E> myList = new MyArrayList<>();

    public boolean isNeedToExpand(){
        return myList.isNeedToExpand();
    }

    public void expand(){
        myList.expand();
    }

    public int length(){
        return myList.getArrayLength();
    }

}
