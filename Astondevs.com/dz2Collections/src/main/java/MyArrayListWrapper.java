//2024.09.30 zip
// ����� ������� ��� ������� � ���������� ��������, ������� �� ������ ���� �������� ������������
//�� ���������� ��� �������� �����
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
