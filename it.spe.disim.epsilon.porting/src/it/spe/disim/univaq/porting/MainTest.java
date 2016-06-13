package it.spe.disim.univaq.porting;

import it.spe.disim.univaq.porting.evl2exl.Evl2Epl;
import it.spe.disim.univaq.porting.evl2exl.Evl2Ewl;
import it.spe.disim.univaq.porting.util.PortingUtil;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.evl.EvlModule;

public class MainTest {

	public static void main(String[] args) throws URISyntaxException, Exception {
		MainTest test = new MainTest();

		AST ewlASTGen, eplASTGen, evlASTGen, evlAST;
		
		
		/** Epl -> Evl & Epl -> Ewl **/
//		EplModule eplM = new EplModule();
//		eplM.parse(test.getFileURI("/epl/basic.epl"));
//		AST eplAST = eplM.getAst();
		//System.out.println(eplAST.toExtendedStringTree());
//		AST ewlASTGen = Epl2Ewl.epl2ewl(eplAST);
//		PortingUtil.ast2file(ewlASTGen, "epl2ewl", "ewl");
//		eplM.parse(test.getFileURI("/epl/basic.epl"));
//		AST evlASTGen = Epl2Evl.epl2evl(eplAST);
//		PortingUtil.ast2file(evlASTGen, "epl2evl", "evl");

		/** Evl -> Epl & Evl -> Ewl **/
		EvlModule evlM = new EvlModule();
		evlM.parse(test.getFileURI("/Users/peo/workspace/test/iwor2016/it.spe.disim.epsilon.antipattern_d-s/evl/AP-UML-MARTE.evl"));
		evlAST = evlM.getAst();
		System.out.println(evlAST);
		eplASTGen = Evl2Epl.evl2epl(evlAST);
		PortingUtil.ast2file(eplASTGen, "AP-UML-MARTE-generated", "epl");
		
		evlM.parse(test.getFileURI("/Users/peo/workspace/test/iwor2016/it.spe.disim.epsilon.antipattern_d-s/evl/AP-UML-MARTE.evl"));
		evlAST = evlM.getAst();
		ewlASTGen = Evl2Ewl.evl2ewl(evlAST);
		PortingUtil.ast2file(ewlASTGen, "AP-UML-MARTE-generated", "ewl");

		/** Ewl -> Epl & Ewl -> Evl **/
/*		EwlModule ewlM = new EwlModule();
		ewlM.parse(test.getFileURI("/ewl/basic.ewl"));
		AST ewlAST = ewlM.getAst();

		AST eplASTGen = Ewl2Epl.ewl2epl(ewlAST);
		System.out.println(PortingUtil.ASTRewrite(eplASTGen));
		PortingUtil.ast2file(eplASTGen, "ewl2epl", "epl");
		
		ewlAST = ewlM.getAst();
		AST evlASTGen = Ewl2Evl.ewl2evl(ewlAST);
		System.out.println(evlASTGen.toExtendedStringTree());
		System.out.println(evlASTGen.getFirstChild().rewrite());
		PortingUtil.ast2file(evlASTGen, "ewl2evl", "evl");
*/

	}

	public URI getFileURI(String fileName) throws URISyntaxException {

//		URI binUri = getClass().getResource(fileName).toURI();
		URI uri = null;
		
		File tempFile = new File("/Users/peo/workspace/test/iwor2016/it.spe.disim.epsilon.antipattern_d-s/evl/AP-UML-MARTE.evl");
		URI binUri = tempFile.toURI();
		System.out.println(tempFile.toURI());
		
		if (binUri.toString().indexOf("bin") > -1) {
			uri = new URI(binUri.toString().replaceAll("bin", "src"));
		} else {
			uri = binUri;
		}
		return uri;
	}
}
