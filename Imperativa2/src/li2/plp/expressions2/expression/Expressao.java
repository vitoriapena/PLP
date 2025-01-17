package li2.plp.expressions2.expression;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.AmbienteExecucao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;

/** 
 * Uma expressao &eacute; a unidade basica na Linguagem de Expressoes.
 */
public interface Expressao {

	/**
	 * Avalia a expressao retornando seu Valor.
	 */
	Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException;

	/**
	 * Avalia a expressao mutada retornando seu Valor.
	 */
	Valor avaliarMutante(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException;

	/**
	 * Realiza a verificacao de tipos desta expressao.
	 *
	 * @param amb o ambiente que contem o mapeamento entre identificadores
	 *          e tipos.
	 * @return <code>true</code> se os tipos da expressao sao validos;
	 *          <code>false</code> caso contrario.
	 */
	boolean checaTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException;

	/**
	 * Retorna os tipos possiveis desta expressao.
	 *
	 * @param amb o ambiente que contem o mapeamento entre identificadores
	 *          e tipos.
	 * @return os tipos possiveis desta expressao.
	 */
	Tipo getTipo(AmbienteCompilacao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException;

	/**
	 * 
	 * @param ambiente
	 * @return Express�o reduzida sem ocorr�ncia de ids conhecidas.
	 */
	Expressao reduzir(AmbienteExecucao ambiente);

	/**
	 * Mutation
	 * @param ambiente
	 * @return Expressão mutada
	 */
	 //Expressao mutate(AmbienteExecucao ambiente) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException;

	/**
	 * 
	 * @return
	 */
	public Expressao clone();
}
