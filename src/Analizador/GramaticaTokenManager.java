/* Generated By:JavaCC: Do not edit this line. GramaticaTokenManager.java */
/** Analizador de expresiones aritmeticas sencillas. */
package Analizador;
import Abstract.AST;
import Expresiones.Aritmetica;
import Expresiones.Relacional;
import Expresiones.Logica;
import Expresiones.Primitivo;
import Expresiones.Identificador;
import Expresiones.Aritmetica.OperadorAritmetico;
import Expresiones.Logica.OperadorLogico;
import Expresiones.Relacional.OperadorRelacional;
import Expresiones.Funcion;
import Expresiones.Llamada;
import Expresiones.Retorno;
import Expresiones.Argumentos;
import Instrucciones.Detener;
import Expresiones.Continue;
import Instrucciones.Imprimir;
import Instrucciones.Declaracion;
import Instrucciones.Si;
import Instrucciones.Mientras;
import Instrucciones.Asignacion;
import TablaSimbolos.Arbol;
import TablaSimbolos.Tipo;
import TablaSimbolos.Tipo.Tipos;
import java.util.ArrayList;

/** Token Manager. */
public class GramaticaTokenManager implements GramaticaConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x1000000L) != 0L)
            return 8;
         if ((active0 & 0x3ff0L) != 0L)
         {
            jjmatchedKind = 36;
            return 1;
         }
         return -1;
      case 1:
         if ((active0 & 0x1000L) != 0L)
            return 1;
         if ((active0 & 0x2ff0L) != 0L)
         {
            jjmatchedKind = 36;
            jjmatchedPos = 1;
            return 1;
         }
         return -1;
      case 2:
         if ((active0 & 0x2ff0L) != 0L)
         {
            jjmatchedKind = 36;
            jjmatchedPos = 2;
            return 1;
         }
         return -1;
      case 3:
         if ((active0 & 0xff0L) != 0L)
         {
            jjmatchedKind = 36;
            jjmatchedPos = 3;
            return 1;
         }
         if ((active0 & 0x2000L) != 0L)
            return 1;
         return -1;
      case 4:
         if ((active0 & 0xbf0L) != 0L)
         {
            jjmatchedKind = 36;
            jjmatchedPos = 4;
            return 1;
         }
         if ((active0 & 0x400L) != 0L)
            return 1;
         return -1;
      case 5:
         if ((active0 & 0x9c0L) != 0L)
         {
            jjmatchedKind = 36;
            jjmatchedPos = 5;
            return 1;
         }
         if ((active0 & 0x230L) != 0L)
            return 1;
         return -1;
      case 6:
         if ((active0 & 0x8c0L) != 0L)
         {
            jjmatchedKind = 36;
            jjmatchedPos = 6;
            return 1;
         }
         if ((active0 & 0x100L) != 0L)
            return 1;
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 35;
         return jjMoveStringLiteralDfa1_0(0x80000000L);
      case 34:
         return jjStopAtPos(0, 1);
      case 38:
         return jjMoveStringLiteralDfa1_0(0x200000000L);
      case 40:
         return jjStopAtPos(0, 15);
      case 41:
         return jjStopAtPos(0, 16);
      case 42:
         return jjStopAtPos(0, 23);
      case 43:
         return jjStopAtPos(0, 21);
      case 44:
         return jjStopAtPos(0, 32);
      case 45:
         return jjStopAtPos(0, 22);
      case 47:
         return jjStartNfaWithStates_0(0, 24, 8);
      case 59:
         return jjStopAtPos(0, 14);
      case 60:
         jjmatchedKind = 26;
         return jjMoveStringLiteralDfa1_0(0x10000000L);
      case 61:
         jjmatchedKind = 25;
         return jjMoveStringLiteralDfa1_0(0x40000000L);
      case 62:
         jjmatchedKind = 27;
         return jjMoveStringLiteralDfa1_0(0x20000000L);
      case 91:
         return jjStopAtPos(0, 17);
      case 93:
         return jjStopAtPos(0, 18);
      case 66:
      case 98:
         return jjMoveStringLiteralDfa1_0(0x400L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa1_0(0x820L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa1_0(0x2000L);
      case 70:
      case 102:
         return jjMoveStringLiteralDfa1_0(0x100L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa1_0(0x1040L);
      case 77:
      case 109:
         return jjMoveStringLiteralDfa1_0(0x80L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa1_0(0x10L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa1_0(0x200L);
      case 123:
         return jjStopAtPos(0, 19);
      case 124:
         return jjMoveStringLiteralDfa1_0(0x400000000L);
      case 125:
         return jjStopAtPos(0, 20);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x200000000L) != 0L)
            return jjStopAtPos(1, 33);
         break;
      case 61:
         if ((active0 & 0x10000000L) != 0L)
            return jjStopAtPos(1, 28);
         else if ((active0 & 0x20000000L) != 0L)
            return jjStopAtPos(1, 29);
         else if ((active0 & 0x40000000L) != 0L)
            return jjStopAtPos(1, 30);
         else if ((active0 & 0x80000000L) != 0L)
            return jjStopAtPos(1, 31);
         break;
      case 65:
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x20L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x200L);
      case 70:
      case 102:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(1, 12, 1);
         break;
      case 73:
      case 105:
         return jjMoveStringLiteralDfa2_0(active0, 0x80L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000L);
      case 77:
      case 109:
         return jjMoveStringLiteralDfa2_0(active0, 0x40L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x800L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x400L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x110L);
      case 124:
         if ((active0 & 0x400000000L) != 0L)
            return jjStopAtPos(1, 34);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 68:
      case 100:
         return jjMoveStringLiteralDfa3_0(active0, 0x20L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x480L);
      case 77:
      case 109:
         return jjMoveStringLiteralDfa3_0(active0, 0x10L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x900L);
      case 80:
      case 112:
         return jjMoveStringLiteralDfa3_0(active0, 0x40L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x200L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 65:
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x400L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa4_0(active0, 0x100L);
      case 69:
      case 101:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(3, 13, 1);
         return jjMoveStringLiteralDfa4_0(active0, 0x30L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa4_0(active0, 0x80L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa4_0(active0, 0x40L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x800L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x200L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 73:
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x940L);
      case 75:
      case 107:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(4, 10, 1);
         break;
      case 78:
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x20L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x210L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x80L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 65:
      case 97:
         if ((active0 & 0x20L) != 0L)
            return jjStartNfaWithStates_0(5, 5, 1);
         break;
      case 77:
      case 109:
         return jjMoveStringLiteralDfa6_0(active0, 0x40L);
      case 78:
      case 110:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(5, 9, 1);
         return jjMoveStringLiteralDfa6_0(active0, 0x800L);
      case 79:
      case 111:
         if ((active0 & 0x10L) != 0L)
            return jjStartNfaWithStates_0(5, 4, 1);
         return jjMoveStringLiteralDfa6_0(active0, 0x100L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa6_0(active0, 0x80L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 65:
      case 97:
         return jjMoveStringLiteralDfa7_0(active0, 0x80L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa7_0(active0, 0x40L);
      case 78:
      case 110:
         if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(6, 8, 1);
         break;
      case 85:
      case 117:
         return jjMoveStringLiteralDfa7_0(active0, 0x800L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 69:
      case 101:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(7, 11, 1);
         break;
      case 82:
      case 114:
         if ((active0 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(7, 6, 1);
         break;
      case 83:
      case 115:
         if ((active0 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(7, 7, 1);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   //int[] nextStates; // not used
   int startsAt = 0;
   jjnewStateCnt = 16;
   int i = 1;
   jjstateSet[0] = startState;
   //int j; // not used
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 8:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(11, 12);
                  else if (curChar == 47)
                  {
                     if (kind > 41)
                        kind = 41;
                     jjCheckNAdd(9);
                  }
                  break;
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 2)
                        kind = 2;
                     jjCheckNAddStates(0, 2);
                  }
                  else if (curChar == 47)
                     jjAddStates(3, 4);
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 36)
                     kind = 36;
                  jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 2:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 2)
                     kind = 2;
                  jjCheckNAddStates(0, 2);
                  break;
               case 3:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 2)
                     kind = 2;
                  jjCheckNAdd(3);
                  break;
               case 4:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(4, 5);
                  break;
               case 5:
                  if (curChar == 46)
                     jjCheckNAdd(6);
                  break;
               case 6:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 3)
                     kind = 3;
                  jjCheckNAdd(6);
                  break;
               case 7:
                  if (curChar == 47)
                     jjAddStates(3, 4);
                  break;
               case 9:
                  if ((0xffffffffffffdbffL & l) == 0L)
                     break;
                  if (kind > 41)
                     kind = 41;
                  jjCheckNAdd(9);
                  break;
               case 10:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(11, 12);
                  break;
               case 11:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(11, 12);
                  break;
               case 12:
                  if (curChar == 42)
                     jjCheckNAddStates(5, 7);
                  break;
               case 13:
                  if ((0xffff7bffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(14, 12);
                  break;
               case 14:
                  if ((0xfffffbffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(14, 12);
                  break;
               case 15:
                  if (curChar == 47 && kind > 42)
                     kind = 42;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 1:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 36)
                     kind = 36;
                  jjCheckNAdd(1);
                  break;
               case 9:
                  if (kind > 41)
                     kind = 41;
                  jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 11:
                  jjCheckNAddTwoStates(11, 12);
                  break;
               case 13:
               case 14:
                  jjCheckNAddTwoStates(14, 12);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 9:
                  if ((jjbitVec0[i2] & l2) == 0L)
                     break;
                  if (kind > 41)
                     kind = 41;
                  jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 11:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjCheckNAddTwoStates(11, 12);
                  break;
               case 13:
               case 14:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjCheckNAddTwoStates(14, 12);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 16 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private final int jjStopStringLiteralDfa_1(int pos, long active0)
{
   switch (pos)
   {
      default :
         return -1;
   }
}
private final int jjStartNfa_1(int pos, long active0)
{
   return jjMoveNfa_1(jjStopStringLiteralDfa_1(pos, active0), pos + 1);
}
private int jjStartNfaWithStates_1(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_1(state, pos + 1);
}
private int jjMoveStringLiteralDfa0_1()
{
   switch(curChar)
   {
      case 34:
         return jjStopAtPos(0, 45);
      default :
         return jjMoveNfa_1(0, 0);
   }
}
private int jjMoveNfa_1(int startState, int curPos)
{
   //int[] nextStates; // not used
   int startsAt = 0;
   jjnewStateCnt = 1;
   int i = 1;
   jjstateSet[0] = startState;
   //int j; // not used
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     kind = 44;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  kind = 44;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((jjbitVec0[i2] & l2) != 0L && kind > 44)
                     kind = 44;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 1 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   3, 4, 5, 8, 10, 12, 13, 15, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, null, 
null, "\73", "\50", "\51", "\133", "\135", "\173", "\175", "\53", "\55", "\52", 
"\57", "\75", "\74", "\76", "\74\75", "\76\75", "\75\75", "\41\75", "\54", "\46\46", 
"\174\174", "\41", null, null, null, null, null, null, null, null, null, null, };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT", 
   "STRING_STATE", 
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 
};
static final long[] jjtoToken = {
   0x201ffffffffdL, 
};
static final long[] jjtoSkip = {
   0xfe000000000L, 
};
static final long[] jjtoMore = {
   0x100000000002L, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[16];
private final int[] jjstateSet = new int[32];
StringBuffer image;
int jjimageLen;
int lengthOfMatch;
protected char curChar;
/** Constructor. */
public GramaticaTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public GramaticaTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 16; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 2 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String tokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   tokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, tokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  //int kind;
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {   
   try   
   {     
      curChar = input_stream.BeginToken();
   }     
   catch(java.io.IOException e)
   {        
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }
   image = null;
   jjimageLen = 0;

   for (;;)
   {
     switch(curLexState)
     {
       case 0:
         try { input_stream.backup(0);
            while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
               curChar = input_stream.BeginToken();
         }
         catch (java.io.IOException e1) { continue EOFLoop; }
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_0();
         if (jjmatchedPos == 0 && jjmatchedKind > 43)
         {
            jjmatchedKind = 43;
         }
         break;
       case 1:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_1();
         break;
     }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else if ((jjtoSkip[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           SkipLexicalActions(null);
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
        jjimageLen += jjmatchedPos + 1;
      if (jjnewLexState[jjmatchedKind] != -1)
        curLexState = jjnewLexState[jjmatchedKind];
        curPos = 0;
        jjmatchedKind = 0x7fffffff;
        try {
           curChar = input_stream.readChar();
           continue;
        }
        catch (java.io.IOException e1) { }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
   }
  }
}

void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      case 43 :
         if (image == null)
            image = new StringBuffer();
         image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
               System.out.println("error");
         break;
      default :
         break;
   }
}
private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
