package lotto.domain;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoTickets {

    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public WinningResult matchResult(final WinningNumber winningNumber) {
        return new WinningResult(lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.matchRank(winningNumber))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

    public LottoTicket getLottoTicket(int index) {
        return lottoTickets.get(index);
    }

    public int size() {
        return lottoTickets.size();
    }

}