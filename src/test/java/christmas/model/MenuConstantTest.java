package christmas.model;

import christmas.constant.menu.MenuKind;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MenuConstantTest {

    int size;
    @BeforeEach
    void setUp() {
        size = 1;
    }

    @Test
    void 에피타이저_테스트() {
        Menu menu = new Menu("양송이수프", size);
        int price = menu.getPrice();
        assertThat(price).isEqualTo(6000);
        boolean isKind = menu.checkKind(MenuKind.APPETIZER);
        assertThat(isKind).isEqualTo(true);

        menu = new Menu("타파스", size);
        price = menu.getPrice();
        assertThat(price).isEqualTo(5500);
        isKind = menu.checkKind(MenuKind.APPETIZER);
        assertThat(isKind).isEqualTo(true);

        menu = new Menu("시저샐러드", size);
        price = menu.getPrice();
        assertThat(price).isEqualTo(8000);
        isKind = menu.checkKind(MenuKind.APPETIZER);
        assertThat(isKind).isEqualTo(true);
    }

    @Test
    void 메인_테스트() {
        Menu menu = new Menu("티본스테이크", size);
        int price = menu.getPrice();
        assertThat(price).isEqualTo(55000);
        boolean isKind = menu.checkKind(MenuKind.MAIN);
        assertThat(isKind).isEqualTo(true);

        menu = new Menu("바비큐립", size);
        price = menu.getPrice();
        assertThat(price).isEqualTo(54000);
        isKind = menu.checkKind(MenuKind.MAIN);
        assertThat(isKind).isEqualTo(true);

        menu = new Menu("해산물파스타", size);
        price = menu.getPrice();
        assertThat(price).isEqualTo(35000);
        isKind = menu.checkKind(MenuKind.MAIN);
        assertThat(isKind).isEqualTo(true);

        menu = new Menu("크리스마스파스타", size);
        price = menu.getPrice();
        assertThat(price).isEqualTo(25000);
        isKind = menu.checkKind(MenuKind.MAIN);
        assertThat(isKind).isEqualTo(true);
    }

    @Test
    void 디저트_테스트() {
        Menu menu = new Menu("초코케이크", size);
        int price = menu.getPrice();
        assertThat(price).isEqualTo(15000);
        boolean isKind = menu.checkKind(MenuKind.DESSERT);
        assertThat(isKind).isEqualTo(true);

        menu = new Menu("아이스크림", size);
        price = menu.getPrice();
        assertThat(price).isEqualTo(5000);
        isKind = menu.checkKind(MenuKind.DESSERT);
        assertThat(isKind).isEqualTo(true);
    }

    @Test
    void 음료_테스트() {
        Menu menu = new Menu("제로콜라", size);
        int price = menu.getPrice();
        assertThat(price).isEqualTo(3000);
        boolean isKind = menu.checkKind(MenuKind.DRINK);
        assertThat(isKind).isEqualTo(true);

        menu = new Menu("레드와인", size);
        price = menu.getPrice();
        assertThat(price).isEqualTo(60000);
        isKind = menu.checkKind(MenuKind.DRINK);
        assertThat(isKind).isEqualTo(true);


        menu = new Menu("샴페인", size);
        price = menu.getPrice();
        assertThat(price).isEqualTo(25000);
        isKind = menu.checkKind(MenuKind.DRINK);
        assertThat(isKind).isEqualTo(true);
    }
}