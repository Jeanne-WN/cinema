import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CinemaTest {
    private Cinema cinema = new Cinema();
    private Double bill;
    private String input;

    @Test
    public void should_return_bill_for_2_tickets() throws IllegalInput {
        bill = 120D;
        input = "{'count':2}";
        assertThat(cinema.getBillFor(input), is(bill));
    }

    @Test
    public void should_return_bill_for_3_tickets() throws IllegalInput {
        bill = 180D;
        input = "{'count':3}";
        assertThat(cinema.getBillFor(input), is(bill));
    }

    @Test
    public void should_return_bill_for_3_tickets_of_2D_movie() throws IllegalInput {
        bill = 180D;
        input = "{'count':3, 'movie_type':'2D'}";
        assertThat(cinema.getBillFor(input), is(bill));
    }

    @Test
    public void should_return_bill_for_3_tickets_of_3D_movie() throws IllegalInput {
        bill = 270D;
        input = "{'count':3, 'movie_type':'3D'}";
        assertThat(cinema.getBillFor(input), is(bill));
    }

    @Test(expected = IllegalInput.class)
    public void should_throw_exception_for_unsupported_movie_type() throws IllegalInput {
        input = "{'count':3, 'movie_type':'4D'}";
        cinema.getBillFor(input);
    }

    @Test
    public void should_return_bill_for_3_tickets_of_3D_movie_paying_by_cash() throws IllegalInput {
        bill = 270D;
        input = "{'count':3, 'movie_type':'3D', 'pay_by':'cash'}";
        assertThat(cinema.getBillFor(input), is(bill));
    }

    @Test
    public void should_return_bill_for_1_tickets_of_2D_movie_paying_by_PFBC_card() throws IllegalInput {
        bill = 42D;
        input = "{'count':1, 'pay_by':'PFBCCard'}";
        assertThat(cinema.getBillFor(input), is(bill));
    }

    @Test
    public void should_return_bill_for_1_tickets_of_2D_movie_paying_by_common_credit_card() throws IllegalInput {
        bill = 60D;
        input = "{'count':1, 'pay_by':'CCCard'}";
        assertThat(cinema.getBillFor(input), is(bill));
    }

}
