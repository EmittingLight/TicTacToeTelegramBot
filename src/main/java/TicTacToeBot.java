import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class TicTacToeBot extends TelegramLongPollingBot {

    private final String botToken;
    private final TicTacToe game;

    public TicTacToeBot(String botToken) {
        this.botToken = botToken;
        this.game = new TicTacToe();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (messageText.equals("/start")) {
                sendStartMessage(chatId);
            } else if (messageText.equals("/newgame")) {
                startNewGame(chatId);
            } else if (messageText.matches("\\d+")) {
                int move = Integer.parseInt(messageText);
                int row = (move - 1) / 3;
                int col = (move - 1) % 3;
                makeMove(chatId, row, col);
            } else {
                sendMessage(chatId, "Неверная команда. Используйте /newgame, чтобы начать новую игру.");
            }
        }
    }

    private void sendStartMessage(long chatId) {
        String message = "Добро пожаловать в бот TicTacToe!\n\n" +
                "Используйте /newgame, чтобы начать новую игру.";
        sendMessage(chatId, message);
    }

    private void startNewGame(long chatId) {
        game.resetBoard();
        String message = "Начать новую игру.\n\n" +
                game.printBoard() +
                "\n\nСделайте свой ход...";
        sendMessage(chatId, message);
    }

    private void makeMove(long chatId, int row, int col) {
        char player = game.getCurrentPlayer();
        game.makeMove(row, col, player);
        String message = game.printBoard();
        if (game.checkForWin()) {
            message += "\n\n" + player + " выиграл! Игра окончена.";
            game.resetBoard();
        } else if (game.checkForDraw()) {
            message += "\n\nНичья! Игра окончена.";
            game.resetBoard();
        } else {
            message += "\n\nСделайте свой ход...";
        }
        sendMessage(chatId, message);
    }

    private void sendMessage(long chatId, String message) {
        SendMessage sendMessage = new SendMessage(String.valueOf(chatId), message);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }



    @Override
    public String getBotUsername() {
        return "TicTacToeBot";
    }

    @Override
    public String getBotToken() {
        return botToken;
    }


}