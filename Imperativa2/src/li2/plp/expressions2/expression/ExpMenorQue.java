package li2.plp.expressions2.expression;

import li2.plp.expressions1.util.Tipo;
import li2.plp.expressions1.util.TipoPrimitivo;
import li2.plp.expressions2.memory.AmbienteCompilacao;
import li2.plp.expressions2.memory.AmbienteExecucao;
import li2.plp.expressions2.memory.VariavelJaDeclaradaException;
import li2.plp.expressions2.memory.VariavelNaoDeclaradaException;

public class ExpMenorQue extends ExpBinaria {

	public ExpMenorQue(Expressao esq, Expressao dir) {
		super(esq, dir, "<");
	}

	/**
	 * Retorna o valor da Expressao de MenorQue
	 */
	public Valor avaliar(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return new ValorBooleano(
			((ValorInteiro) getEsq().avaliar(amb)).valor() <
			((ValorInteiro) getDir().avaliar(amb)).valor() );
	}

	/**
	 * Retorna o valor da Expressao Mutante de MenorQue
	 */
	public Valor avaliarMutante(AmbienteExecucao amb) throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return new ValorBooleano(
				((ValorInteiro) getEsq().avaliar(amb)).valor() <=
						((ValorInteiro) getDir().avaliar(amb)).valor() );
	}

	/**
	 * Realiza a verificacao de tipos desta expressao.
	 *
	 * @param ambiente o ambiente de compila��o.
	 * @return <code>true</code> se os tipos da expressao sao validos;
	 *          <code>false</code> caso contrario.
	 * @exception VariavelNaoDeclaradaException se existir um identificador
	 *          nao declarado no ambiente.
	 * @exception VariavelNaoDeclaradaException se existir um identificador
	 *          declarado mais de uma vez no mesmo bloco do ambiente.
	 */
	protected boolean checaTipoElementoTerminal(AmbienteCompilacao ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		return (getEsq().getTipo(ambiente).eInteiro() && getDir().getTipo(ambiente).eInteiro());
	}

	/**
	 * Retorna os tipos possiveis desta expressao.
	 *
	 * @param ambiente o ambiente de compila��o.
	 * @return os tipos possiveis desta expressao.
	 */
	public Tipo getTipo(AmbienteCompilacao ambiente) {
		return TipoPrimitivo.BOOLEANO;
	}
	
	public ExpMenorQue clone() {
		return new ExpMenorQue(this.esq.clone(), this.dir.clone());
	}
}
