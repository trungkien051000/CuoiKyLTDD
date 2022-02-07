package SignInSignUp;

public class HinhAnh {
    String Ten;
    int Hinh,option;

    public HinhAnh(String ten, int hinh) {
        Ten = ten;
        Hinh = hinh;
    }

    public HinhAnh(String ten, int hinh, int option) {
        Ten = ten;
        Hinh = hinh;
        this.option = option;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }
}
