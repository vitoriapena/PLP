package li2.plp.expressions2.expression;

import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;

/**
 * <code>Valor</code> agrupa valores concretos e abstratos
*/

public interface Valor extends Expressao {

    @Override
    default boolean checaTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
        return false;
    }
}