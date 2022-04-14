# 숫자 야구 게임

## 진행 방식
* 미션은 기능 요구사항, 프로그래밍 요구사항, 과제 진행 요구사항 세 가지로 구성되어 있다. 
* 세 개의 요구사항을 만족하기 위해 노력한다.
* 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능단위로 commit 하는 방식으로 진행한다.
* 기능 요구사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## 기능 요구사항
* 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
* 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
* [예] 상대방(컴퓨터)의수가425일때,
* 123을 제시한 경우 :1스트라이크
* 456을 제시한 경우: 1볼1스트라이크
* 789를 제시한 경우: 낫싱
* 위 숫자야구게임에서 상대방의 역할을 컴퓨터가 한다.
* 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
* 게임 플 레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 게임 플레이어가 입력한 숫자에 대한 결과를 출력한다.
* 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
* 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 프로그래밍 제약사항 1
* 숫자야구게임을 실행하는 시작점은 src/main/java 폴더의 baseball.Application의 main()이다.
* 숫자야구게임은 JDK8버전에서 실행 가능해야 한다. JDK8에서 정상 동작하지 않을 경우 0점 처리한다.
* JDK에서 제공하는 Random 및 ScannerAPI 대신 camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 ConsoleAPI를 사용하여 구현해야 한다.
* Random 값 추출 은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
* 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
* 프로그램 구현을 완료했을 때 src/test/java 폴더의 baseball.ApplicationTest에 있는 2개의 TestCase가 성공해야 한다.
* 테스트가 실패할 경우 0점 처리한다.
* ApplicationTest에서 제공하는 2개의 TestCase는 숫자야구게임 구현을 위한 최소한의 TestCase이다.
* 필수 요구사항은 아니지만 제공하는 소스코드를 참고해 숫자야구게임을 위한 모든 TestCase를 추가해 보는 것도 테스트에 대한 좋은 연습이 될 수 있다.

## 프로그래밍 제약사항 2
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  * https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java
* indent(인 덴트, 들여 쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
* 예를 들어 while 문안에 if 문이 있으면 들여 쓰기는 2이다.
  * 힌트:indent(인 덴트, 들여 쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
* 자바 8에 추가된 streamAPI를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다.
* else 예약어를 쓰지 않는다.
  * 힌트: if 조건 절에서 값을 return 하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
* 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
* 함수(또는 메서드)가 한 가지 일만 잘하도록 구현한다.

## 프로그래밍 제약사항 3
* 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner)로 직은 제외
* 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
* 힌트는 MVC 패턴 기반으로 구현한 후 View, Controller를 제외한 Model에 대한 단위 테스트를 추가하는 것에 집중한다.
* JUnit5와 AssertJ 사용법에 익숙하지 않은 개발자는 첨부한"학습 테스트를 통해 JUnit 학습하기.
* pdf"문서를 참고해 사용법을 학습한 후 JUnit5기반 단위 테스트를 구현한다.

## 구현목록
* Team
  * createComputer(): Team -> 1부터 9까지의 숫자 중 중복되지 않는 3자리 숫자를 뽑아 컴퓨터 객체 만든다.
  * pickNumber(Set): Int -> 중복되지 않는 숫자를 선택한다.
  * createUser(String): Team -> 입력받은 숫자를 검증하고 유저 객체를 만든다.

* Result
  * from(Team, Team): Result -> 스트라이크 카운트와 볼 카운트를 구한 객체를 만든다.
  * result(): boolean -> 3스트라이크 일 때 true 이 외 false 를 반환한다.
  * getStrikeCount(): int -> user와 computer를 비교해 strike count 를 구한다.
  * getBallCount(): int -> user와 computer를 비교해 ball count 를 구한다.
  * cal(int, int): int -> left 와 right를 비교해 같으면 1 다르면 0을 반환한다.
  * printMessage() -> 결과를 출력한다.
  * getMessage() -> 스트라이크 카운트와 볼 카운트를 계산해 출력할 메세지를 가공한다.

* Game
  * play(Team): boolean -> 야구 게임을 시작한다. 인자로 computer가 null이면 생성한다.
  * isKeepGoing(): boolean -> 게임을 계속할지 종료할지 선택하여 `boolean` type을 반 한한다.

* NumberUtils
  * correctNumeric(String) -> 인자로 받은 값이 숫자가 아니면 `IllegalArgumentException` 을 반환한다.
  * validNumberLength(String, int) -> 인자로 받은 String의 길이가 인자로 받은 length보다 크면 `IllegalArgumentException` 을 반환한다.
  * validInput(String, int) -> 숫자인지 길이가 정상인지 확인한다.