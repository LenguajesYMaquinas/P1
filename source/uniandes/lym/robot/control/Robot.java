/* Generated By:JavaCC: Do not edit this line. Robot.java */
package uniandes.lym.robot.control;

import uniandes.lym.robot.kernel.*;
import uniandes.lym.robot.view.Console;
import java.awt.Point;
import java.io.*;
import java.util.Vector;
import java.util.LinkedList;
import java.util.HashMap;
import java.lang.String;
import java.lang.Integer;

@SuppressWarnings("serial")
public class Robot implements RobotConstants {

        public static HashMap<String, Integer> variables = new HashMap<String, Integer>();

        private RobotWorldDec world;


        void setWorld(RobotWorld w) {
                world = (RobotWorldDec) w;
        }

        String salida=new String();

//boolean command(uniandes.lym.robot.view.Console sistema) :
  final public boolean command(Console sistema) throws ParseException {
        int x,y;
        salida=new String();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ROBOTR:
      program();
                try {
                Thread.sleep(900);
            }
            catch(InterruptedException e) {
                System.err.format("IOException: %s%n", e);
            }
                {if (true) return true;}
      break;
    case 0:
      jj_consume_token(0);
                 {if (true) return false;}
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public void program() throws ParseException {
    jj_consume_token(ROBOTR);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VARS:
      variablesDeclaration();
      break;
    default:
      jj_la1[1] = jj_gen;
      ;
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PROCS:
      proceduresDeclaration();
      break;
    default:
      jj_la1[2] = jj_gen;
      ;
    }
    instructionsBlocK();
  }

  final public void variablesDeclaration() throws ParseException {
    jj_consume_token(VARS);
    saveVariable();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_1;
      }
      jj_consume_token(COMMA);
      saveVariable();
    }
    jj_consume_token(SEMICOLON);
  }

  final public void proceduresDeclaration() throws ParseException {
    jj_consume_token(PROCS);
    label_2:
    while (true) {
      jj_consume_token(STRING);
      jj_consume_token(LSQUAREBRACKET);
      jj_consume_token(BAR);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STRING:
        jj_consume_token(STRING);
        label_3:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case COMMA:
            ;
            break;
          default:
            jj_la1[4] = jj_gen;
            break label_3;
          }
          jj_consume_token(COMMA);
          jj_consume_token(STRING);
        }
        break;
      default:
        jj_la1[5] = jj_gen;
        ;
      }
      jj_consume_token(BAR);
      instruction();
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SEMICOLON:
          ;
          break;
        default:
          jj_la1[6] = jj_gen;
          break label_4;
        }
        jj_consume_token(SEMICOLON);
        instruction();
      }
      jj_consume_token(RSQUAREBRACKET);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STRING:
        ;
        break;
      default:
        jj_la1[7] = jj_gen;
        break label_2;
      }
    }
  }

  final public void instructionsBlocK() throws ParseException {
    jj_consume_token(LSQUAREBRACKET);
    instruction();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SEMICOLON:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_5;
      }
      jj_consume_token(SEMICOLON);
      instruction();
    }
    jj_consume_token(RSQUAREBRACKET);
  }

  final public void instruction() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case RIGHT:
    case PUT:
    case PICK:
    case POP:
    case HOP:
    case ASSIGNTO:
    case GOTO:
    case MOVE:
    case TURN:
    case FACE:
    case MOVETOTHE:
    case MOVEINDIR:
    case JUMPTOTHE:
    case JUMPINDIR:
    case NOP:
      commandInstruction();
      break;
    case IF:
    case WHILE:
    case REPEAT:
      structureControl();
      break;
    case STRING:
      procedureCall();
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void commandInstruction() throws ParseException {
  int x=0;
  int y=0;
  String text = "";
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case HOP:
      jj_consume_token(HOP);
      jj_consume_token(LPARENTHESIS);
      x = charNumToInt();
      jj_consume_token(RPARENTHESIS);
                                                                            world.moveForward(x,true);
      break;
    case POP:
      jj_consume_token(POP);
      jj_consume_token(LPARENTHESIS);
      x = charNumToInt();
      jj_consume_token(RPARENTHESIS);
                                                                             world.popBalloons(x);
      break;
    case RIGHT:
      jj_consume_token(RIGHT);
      jj_consume_token(LPARENTHESIS);
      jj_consume_token(RPARENTHESIS);
                                                             world.turnRight();
      break;
    case MOVE:
      jj_consume_token(MOVE);
      jj_consume_token(COLON);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMBER:
        x = charNumToInt();
        break;
      case STRING:
        jj_consume_token(STRING);
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
                                                                    world.moveForward(x,false);
      break;
    case ASSIGNTO:
      jj_consume_token(ASSIGNTO);
      jj_consume_token(COLON);
      x = charNumToInt();
      jj_consume_token(COMMA);
      saveValueToVariable(x);
      break;
    case GOTO:
      jj_consume_token(GOTO);
      jj_consume_token(COLON);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMBER:
        x = charNumToInt();
        break;
      case STRING:
        jj_consume_token(STRING);
        break;
      default:
        jj_la1[11] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(COMMA);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMBER:
        y = charNumToInt();
        break;
      case STRING:
        jj_consume_token(STRING);
        break;
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
                                                                                                              world.setPostion(x,y);
      break;
    case TURN:
      jj_consume_token(TURN);
      jj_consume_token(COLON);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LEFT:
        jj_consume_token(LEFT);
        break;
      case RIGHT:
        jj_consume_token(RIGHT);
        break;
      case AROUND:
        jj_consume_token(AROUND);
        break;
      default:
        jj_la1[13] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case FACE:
      jj_consume_token(FACE);
      jj_consume_token(COLON);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NORTH:
        jj_consume_token(NORTH);
        break;
      case SOUTH:
        jj_consume_token(SOUTH);
        break;
      case EAST:
        jj_consume_token(EAST);
        break;
      case WEST:
        jj_consume_token(WEST);
        break;
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case PUT:
      jj_consume_token(PUT);
      jj_consume_token(COLON);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMBER:
        x = charNumToInt();
        break;
      case STRING:
        jj_consume_token(STRING);
        break;
      default:
        jj_la1[15] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(COMMA);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BALLOONS:
        jj_consume_token(BALLOONS);
                                                                                           world.putBalloons(x);
        break;
      case CHIPS:
        jj_consume_token(CHIPS);
                                                                                                                               world.putChips(x);
        break;
      default:
        jj_la1[16] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case PICK:
      jj_consume_token(PICK);
      jj_consume_token(COLON);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMBER:
        x = charNumToInt();
        break;
      case STRING:
        jj_consume_token(STRING);
        break;
      default:
        jj_la1[17] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(COMMA);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case BALLOONS:
        jj_consume_token(BALLOONS);
                                                                                            world.grabBalloons(x);
        break;
      case CHIPS:
        jj_consume_token(CHIPS);
                                                                                                                                 world.pickChips(x);
        break;
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case MOVETOTHE:
      jj_consume_token(MOVETOTHE);
      jj_consume_token(COLON);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMBER:
        jj_consume_token(NUMBER);
        break;
      case STRING:
        jj_consume_token(STRING);
        break;
      default:
        jj_la1[19] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(COMMA);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FRONT:
        jj_consume_token(FRONT);
        break;
      case LEFT:
        jj_consume_token(LEFT);
        break;
      case RIGHT:
        jj_consume_token(RIGHT);
        break;
      case BACK:
        jj_consume_token(BACK);
        break;
      default:
        jj_la1[20] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case JUMPTOTHE:
      jj_consume_token(JUMPTOTHE);
      jj_consume_token(COLON);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMBER:
        jj_consume_token(NUMBER);
        break;
      case STRING:
        jj_consume_token(STRING);
        break;
      default:
        jj_la1[21] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(COMMA);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FRONT:
        jj_consume_token(FRONT);
        break;
      case LEFT:
        jj_consume_token(LEFT);
        break;
      case RIGHT:
        jj_consume_token(RIGHT);
        break;
      case BACK:
        jj_consume_token(BACK);
        break;
      default:
        jj_la1[22] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case MOVEINDIR:
      jj_consume_token(MOVEINDIR);
      jj_consume_token(COLON);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMBER:
        jj_consume_token(NUMBER);
        break;
      case STRING:
        jj_consume_token(STRING);
        break;
      default:
        jj_la1[23] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(COMMA);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NORTH:
        jj_consume_token(NORTH);
        break;
      case SOUTH:
        jj_consume_token(SOUTH);
        break;
      case EAST:
        jj_consume_token(EAST);
        break;
      case WEST:
        jj_consume_token(WEST);
        break;
      default:
        jj_la1[24] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case JUMPINDIR:
      jj_consume_token(JUMPINDIR);
      jj_consume_token(COLON);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMBER:
        jj_consume_token(NUMBER);
        break;
      case STRING:
        jj_consume_token(STRING);
        break;
      default:
        jj_la1[25] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(COMMA);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NORTH:
        jj_consume_token(NORTH);
        break;
      case SOUTH:
        jj_consume_token(SOUTH);
        break;
      case EAST:
        jj_consume_token(EAST);
        break;
      case WEST:
        jj_consume_token(WEST);
        break;
      default:
        jj_la1[26] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    case NOP:
      jj_consume_token(NOP);
      jj_consume_token(COLON);
      break;
    default:
      jj_la1[27] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void structureControl() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IF:
      conditionalIf();
      break;
    case WHILE:
      loop();
      break;
    case REPEAT:
      repeat();
      break;
    default:
      jj_la1[28] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void conditionalIf() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(COLON);
    condition();
    jj_consume_token(THEN);
    jj_consume_token(COLON);
    instructionsBlocK();
    jj_consume_token(ELSE);
    jj_consume_token(COLON);
    instructionsBlocK();
  }

  final public void loop() throws ParseException {
    jj_consume_token(WHILE);
    jj_consume_token(COLON);
    condition();
    jj_consume_token(DO);
    jj_consume_token(COLON);
    instructionsBlocK();
  }

  final public void repeat() throws ParseException {
    jj_consume_token(REPEAT);
    jj_consume_token(COLON);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
      jj_consume_token(NUMBER);
      break;
    case STRING:
      jj_consume_token(STRING);
      break;
    default:
      jj_la1[29] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    instructionsBlocK();
  }

  final public void condition() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FACING:
      facing();
      break;
    case CANPUT:
      canPut();
      break;
    case CANPICK:
      canPick();
      break;
    case CANMOVEINDIR:
      canMoveIn();
      break;
    case CANJUMPINDIR:
      canJumpIn();
      break;
    case CANMOVETOTHE:
      canMoveTo();
      break;
    case CANJUMPTOTHE:
      canJumpTo();
      break;
    case NOT:
      not();
      break;
    default:
      jj_la1[30] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void facing() throws ParseException {
    jj_consume_token(FACING);
    jj_consume_token(COLON);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NORTH:
      jj_consume_token(NORTH);
      break;
    case SOUTH:
      jj_consume_token(SOUTH);
      break;
    case EAST:
      jj_consume_token(EAST);
      break;
    case WEST:
      jj_consume_token(WEST);
      break;
    default:
      jj_la1[31] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void canPut() throws ParseException {
    jj_consume_token(CANPUT);
    jj_consume_token(COLON);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
      jj_consume_token(NUMBER);
      break;
    case STRING:
      jj_consume_token(STRING);
      break;
    default:
      jj_la1[32] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(COMMA);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CHIPS:
      jj_consume_token(CHIPS);
      break;
    case BALLOONS:
      jj_consume_token(BALLOONS);
      break;
    default:
      jj_la1[33] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void canPick() throws ParseException {
    jj_consume_token(CANPICK);
    jj_consume_token(COLON);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
      jj_consume_token(NUMBER);
      break;
    case STRING:
      jj_consume_token(STRING);
      break;
    default:
      jj_la1[34] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(COMMA);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case CHIPS:
      jj_consume_token(CHIPS);
      break;
    case BALLOONS:
      jj_consume_token(BALLOONS);
      break;
    default:
      jj_la1[35] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void canMoveIn() throws ParseException {
    jj_consume_token(CANMOVEINDIR);
    jj_consume_token(COLON);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
      jj_consume_token(NUMBER);
      break;
    case STRING:
      jj_consume_token(STRING);
      break;
    default:
      jj_la1[36] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(COMMA);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NORTH:
      jj_consume_token(NORTH);
      break;
    case SOUTH:
      jj_consume_token(SOUTH);
      break;
    case EAST:
      jj_consume_token(EAST);
      break;
    case WEST:
      jj_consume_token(WEST);
      break;
    default:
      jj_la1[37] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void canJumpIn() throws ParseException {
    jj_consume_token(CANJUMPINDIR);
    jj_consume_token(COLON);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
      jj_consume_token(NUMBER);
      break;
    case STRING:
      jj_consume_token(STRING);
      break;
    default:
      jj_la1[38] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(COMMA);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NORTH:
      jj_consume_token(NORTH);
      break;
    case SOUTH:
      jj_consume_token(SOUTH);
      break;
    case EAST:
      jj_consume_token(EAST);
      break;
    case WEST:
      jj_consume_token(WEST);
      break;
    default:
      jj_la1[39] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void canMoveTo() throws ParseException {
    jj_consume_token(CANMOVETOTHE);
    jj_consume_token(COLON);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
      jj_consume_token(NUMBER);
      break;
    case STRING:
      jj_consume_token(STRING);
      break;
    default:
      jj_la1[40] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(COMMA);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FRONT:
      jj_consume_token(FRONT);
      break;
    case RIGHT:
      jj_consume_token(RIGHT);
      break;
    case LEFT:
      jj_consume_token(LEFT);
      break;
    case BACK:
      jj_consume_token(BACK);
      break;
    default:
      jj_la1[41] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void canJumpTo() throws ParseException {
    jj_consume_token(CANJUMPTOTHE);
    jj_consume_token(COLON);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
      jj_consume_token(NUMBER);
      break;
    case STRING:
      jj_consume_token(STRING);
      break;
    default:
      jj_la1[42] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(COMMA);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FRONT:
      jj_consume_token(FRONT);
      break;
    case RIGHT:
      jj_consume_token(RIGHT);
      break;
    case LEFT:
      jj_consume_token(LEFT);
      break;
    case BACK:
      jj_consume_token(BACK);
      break;
    default:
      jj_la1[43] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void not() throws ParseException {
    jj_consume_token(NOT);
    jj_consume_token(COLON);
    condition();
  }

  final public void procedureCall() throws ParseException {
    jj_consume_token(STRING);
    jj_consume_token(COLON);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
    case STRING:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case STRING:
        jj_consume_token(STRING);
        break;
      case NUMBER:
        jj_consume_token(NUMBER);
        break;
      default:
        jj_la1[44] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case COMMA:
          ;
          break;
        default:
          jj_la1[45] = jj_gen;
          break label_6;
        }
        jj_consume_token(COMMA);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case STRING:
          jj_consume_token(STRING);
          break;
        case NUMBER:
          jj_consume_token(NUMBER);
          break;
        default:
          jj_la1[46] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
      break;
    default:
      jj_la1[47] = jj_gen;
      ;
    }
  }

  final public int charNumToInt() throws ParseException, Error {
        int total=1;
    jj_consume_token(NUMBER);
                try{
                        total = Integer.parseInt(token.image);
                }
                catch (NumberFormatException ee){
                        {if (true) throw new Error("Number out of bounds: "+token.image+" !!");}
                }
                {if (true) return total;}
    throw new Error("Missing return statement in function");
  }

  final public void saveVariable() throws ParseException {
        String variableName = "";
    jj_consume_token(STRING);
                variableName=token.image;
                Robot.variables.put(variableName, -1);
                /*System.out.println(Robot.variables.keySet());*/

  }

  final public void saveValueToVariable(int value) throws ParseException, Error {
        String variableName = "";
    jj_consume_token(STRING);
                variableName=token.image;
                if(Robot.variables.replace(variableName, value) != null) {
                  Robot.variables.replace(variableName, value);
                }
                else{
                  {if (true) throw new Error("The variable " + variableName +  " has not been declared.");}
                }
                /*System.out.println(Robot.variables.toString());*/

  }

  /** Generated Token Manager. */
  public RobotTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[48];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x21,0x40,0x80,0x0,0x0,0x0,0x0,0x0,0x0,0x80310000,0x0,0x0,0x0,0x80000300,0xf000,0x0,0x0,0x0,0x0,0x0,0x80000d00,0x0,0x80000d00,0x0,0xf000,0x0,0xf000,0x80000000,0x310000,0x0,0x3fc00000,0xf000,0x0,0x0,0x0,0x0,0x0,0xf000,0x0,0xf000,0x0,0x80000d00,0x0,0x80000d00,0x0,0x0,0x0,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x20000,0x20000,0x10000000,0x80000,0x10000000,0x80000,0x10007ff7,0x18000000,0x18000000,0x18000000,0x0,0x0,0x18000000,0x18000,0x18000000,0x18000,0x18000000,0x0,0x18000000,0x0,0x18000000,0x0,0x18000000,0x0,0x7ff7,0x0,0x18000000,0x0,0x0,0x18000000,0x18000,0x18000000,0x18000,0x18000000,0x0,0x18000000,0x0,0x18000000,0x0,0x18000000,0x0,0x18000000,0x20000,0x18000000,0x18000000,};
   }

  /** Constructor with InputStream. */
  public Robot(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Robot(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new RobotTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 48; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 48; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Robot(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new RobotTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 48; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 48; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Robot(RobotTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 48; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(RobotTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 48; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[61];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 48; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 61; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
