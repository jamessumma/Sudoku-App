package sudoku.sudokuapp;

public class HelloApplication {

//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello james!");
//        stage.setScene(scene);
//        stage.show();
//    }

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println();
        for (int i = 0; i < 9; i++) {
            System.out.print(game.board[0][i]);
        }

        //launch();
    }
}