import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyBotStarter {
    public static void main(String[] args) throws TelegramApiException {
        String botToken = "Введите свой токен";
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            botsApi.registerBot(new TicTacToeBot(botToken));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}